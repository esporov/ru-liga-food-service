package ru.liga.service.impl;

import ru.liga.domain.enitity.kitchenService.restaurant.Restaurant;
import ru.liga.domain.enitity.kitchenService.restaurant.RestaurantAddress;
import ru.liga.domain.enitity.kitchenService.restaurant.RestaurantStatus;
import ru.liga.domain.exception.IllegalStatusException;
import ru.liga.domain.exception.ResourceNotFoundException;
import ru.liga.interfaces.EnumToStringConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.repository.RestaurantRepository;
import ru.liga.service.RestaurantService;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService, EnumToStringConverter {

    private final RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant getRestaurantByRestaurantId(long id) {
        try {
            return restaurantRepository.getRestaurantByRestaurantId(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Ресторана с id = " + id + " не существует."));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public RestaurantAddress getRestaurantAddressByAddressId(long id) {
        try {
            return restaurantRepository.getRestaurantAddressByAddressId(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Адреса с id = " + id + " не существует."));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<RestaurantAddress> getAllRestaurantAddressesByRestaurantId(long id) {
        try {
            List<RestaurantAddress> addresses = restaurantRepository.getAllRestaurantAddressesByRestaurantId(id);
            if (addresses.size() == 0) {
                throw new ResourceNotFoundException("Ресторана с id = " + id + " не существует.");
            }
            return addresses;
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<RestaurantAddress> getAllRestaurantAddressesByRestaurantName(String name) {
        try {
            List<RestaurantAddress> addresses = restaurantRepository
                    .getAllRestaurantAddressesByRestaurantName(name);
            if (addresses.size() == 0) {
                throw new ResourceNotFoundException("Ресторана с именем '" + name + "' не существует.");
            }
            return addresses;
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public RestaurantAddress updateRestaurantAddressStatusByAddressId(long id, String status) {
        try {
            RestaurantStatus.valueOf(status);
            restaurantRepository.updateRestaurantAddressStatusByAddressId(
                    id, RestaurantStatus.valueOf(status));
            return getRestaurantAddressByAddressId(id);
        } catch (IllegalArgumentException e) {
            String enums = enumToString(RestaurantStatus.class);
            String message = String.format("Указан неверный статус. Возможны варианты: %s", enums);
            throw new IllegalStatusException(message, e);
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException("Указанный адрес ресторана не найден.", e);
        }
    }

    @Override
    public List<RestaurantAddress> getRestaurantAddressesByRestaurantIdAndRestaurantStatus(
            long id, String status) {
        try {
            RestaurantStatus.valueOf(status);
            List<RestaurantAddress> addresses = restaurantRepository
                    .getRestaurantAddressesByRestaurantIdAndRestaurantStatus(
                            id, RestaurantStatus.valueOf(status));
            if (addresses.size() == 0) {
                throw new ResourceNotFoundException("Ресторана с id = " + id + " не существует.");
            }
            return addresses;
        } catch (IllegalArgumentException e) {
            String enums = enumToString(RestaurantStatus.class);
            String message = String.format("Указан неверный статус. Возможны варианты: %s", enums);
            throw new IllegalStatusException(message, e);
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException("Указанный адрес ресторана не найден.", e);
        }
    }

    @Transactional
    @Override
    public void createRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }


}
