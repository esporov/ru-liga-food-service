package ru.liga.service;

import ru.liga.domain.restaurant.Restaurant;
import ru.liga.domain.exception.RestaurantNotFoundException;
import ru.liga.domain.restaurant.RestaurantAddress;

import java.util.List;

public interface RestaurantService {

    Restaurant getRestaurantByRestaurantId(long id) throws RestaurantNotFoundException;
    List<RestaurantAddress> getAllRestaurantsByRestaurantId(long id) throws RestaurantNotFoundException;
    List<Restaurant> getAllDistinctRestaurants();
    List<Restaurant> getAllRestaurantsByRestaurantName(String name);
    void updateRestaurantName(String restaurantName, String newRestaurantName);
    void updateRestaurantStatusByAddressId(long addressId, String restaurantStatus);
    public List<RestaurantAddress> getRestaurantByRestaurantStatus(String restaurantStatus);
    void createRestaurant(Restaurant restaurant);
}
