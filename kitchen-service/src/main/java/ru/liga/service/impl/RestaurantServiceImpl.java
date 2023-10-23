package ru.liga.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.domain.exception.RestaurantNotFoundException;
import ru.liga.domain.restaurant.Restaurant;
import ru.liga.domain.restaurant.RestaurantAddress;
import ru.liga.domain.restaurant.RestaurantStatus;
import ru.liga.repository.RestaurantRepository;
import ru.liga.service.RestaurantService;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository repository) {
        this.restaurantRepository = repository;
    }

    @Override
    public Restaurant getRestaurantByRestaurantId(long id) {
        return restaurantRepository.getRestaurantByRestaurantId(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found."));
    }

    @Override
    public List<RestaurantAddress> getAllRestaurantsByRestaurantId(long id) {
        List<RestaurantAddress> restaurants = restaurantRepository.getAllRestaurantsByRestaurantId(id);
        if (!restaurants.isEmpty()) {
            return restaurants;
        } else {
            throw new RestaurantNotFoundException("Restaurant not found.");
        }
    }

    @Override
    public List<Restaurant> getAllDistinctRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> getAllRestaurantsByRestaurantName(String RestaurantName) {
        return restaurantRepository.findAllByRestaurantName(RestaurantName);
    }

    @Override
    public void updateRestaurantName(String restaurantName, String newRestaurantName) {
        restaurantRepository.updateByRestaurantName(restaurantName, newRestaurantName);
    }
    @Override
    @Transactional
    public void updateRestaurantStatusByAddressId(long addressId, String restaurantStatus) {
        try {
            RestaurantStatus.valueOf(restaurantStatus);
        } catch (IllegalArgumentException e) {
            //TODO
        }
        restaurantRepository.updateRestaurantStatusByAddressId(addressId, restaurantStatus);
    }

    @Transactional
    @Override
    public List<RestaurantAddress> getRestaurantByRestaurantStatus(String restaurantStatus) {
        return restaurantRepository.getRestaurantByRestaurantStatus(RestaurantStatus.valueOf(restaurantStatus));
    }

    @Override
    public void createRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

}
