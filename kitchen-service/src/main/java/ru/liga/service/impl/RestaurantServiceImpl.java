package ru.liga.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.domain.enitity.kitchenService.restaurant.Restaurant;
import ru.liga.domain.enitity.kitchenService.restaurant.RestaurantAddress;
import ru.liga.domain.enitity.kitchenService.restaurant.RestaurantStatus;
import ru.liga.domain.exception.IllegalStatusException;
import ru.liga.domain.exception.RestaurantNotFoundException;
import ru.liga.util.IllegalStatusExceptionMessage;
import ru.liga.repository.RestaurantAddressRepository;
import ru.liga.repository.RestaurantRepository;
import ru.liga.service.RestaurantService;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class RestaurantServiceImpl implements RestaurantService, IllegalStatusExceptionMessage {

    private final Logger LOGGER = LoggerFactory.getLogger(RestaurantServiceImpl.class);

    private final RestaurantRepository restaurantRepository;
    private final RestaurantAddressRepository restaurantAddressRepository;

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant getRestaurantByRestaurantId(long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(
                        "Ресторана с id = " + id + " не существует. Операция прервана."));
    }

    @Override
    public Restaurant getRestaurantByRestaurantName(String name) {
        return restaurantRepository.findRestaurantByRestaurantName(name)
                .orElseThrow(() -> new RestaurantNotFoundException(
                        "Ресторана с название = " + name + " не существует. Операция прервана."));
    }

    @Override
    public RestaurantAddress getRestaurantAddressByAddressId(long id) {
        return restaurantAddressRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(
                        "Адрес ресторана с id = " + id + " не существует."));
    }

    @Override
    public List<RestaurantAddress> getAllRestaurantAddressesByRestaurantId(long id) {
        getRestaurantByRestaurantId(id);
        List<RestaurantAddress> addresses = restaurantAddressRepository.getAllRestaurantAddressesByRestaurantId(id);
        if (addresses.size() == 0) {
            throw new RestaurantNotFoundException(
                    "Адресов ресторана с id = " + id + " не существует. Операция прервана.");
        }
        return addresses;
    }

    @Override
    public List<RestaurantAddress> getAllRestaurantAddressesByRestaurantName(String name) {
        List<RestaurantAddress> addresses = restaurantAddressRepository
                .getAllRestaurantAddressesByRestaurantName(name);
        if (addresses.size() == 0) {
            throw new RestaurantNotFoundException(
                    "Ресторана с именем '" + name + "' не существует. Операция прервана.");
        }
        return addresses;
    }

    @Override
    @Transactional
    public RestaurantAddress updateRestaurantAddressStatusByAddressId(long id, String status) {
        try {
            LOGGER.info("Проверяем на наличие RestaurantAddress.id = {}", id);
            var restaurantAddress = getRestaurantAddressByAddressId(id);
            LOGGER.info("Выполняем проверку на валидность RestaurantAddress.RestaurantStatus = {}", status);
            RestaurantStatus validStatus = RestaurantStatus.valueOf(status);
            LOGGER.info("Обновляем данные в БД для адреса по id = {}, обновляем статус на {}", id , status);
            restaurantAddressRepository.updateRestaurantAddressStatusByAddressId(
                    id, validStatus);
            restaurantAddress.setRestaurantStatus(validStatus);
            return restaurantAddress;
        } catch (IllegalArgumentException e) {
            throw new IllegalStatusException(exceptionMessage(RestaurantStatus.class), e);
        }
    }

    @Override
    public List<RestaurantAddress> getAllRestaurantAddressByRestaurantIdAndRestaurantStatus(long id, String status) {
        try {
            getRestaurantByRestaurantId(id);
            var validRestaurantStatus = RestaurantStatus.valueOf(status);
            List<RestaurantAddress> addresses = restaurantAddressRepository
                    .getAllRestaurantAddressByRestaurantIdAndRestaurantStatus(id, validRestaurantStatus);
            if (addresses.size() == 0) {
                throw new RestaurantNotFoundException(
                        "Адресов ресторана с id = " + id + " и статусом = " + status + " не существует.");
            }
            return addresses;
        } catch (IllegalArgumentException e) {
            throw new IllegalStatusException(exceptionMessage(RestaurantStatus.class), e);
        }
    }

    @Transactional
    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        getRestaurantByRestaurantName(restaurant.getRestaurantName());
        return restaurantRepository.save(restaurant);
    }

    @Transactional
    @Override
    public RestaurantAddress createRestaurantAddressByRestaurantId(long restaurantId, RestaurantAddress address) {
        var restaurant = getRestaurantByRestaurantId(restaurantId);
        address.setRestaurant(restaurant);
        return restaurantAddressRepository.save(address);
    }
}
