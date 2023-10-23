package ru.liga.service;

import ru.liga.domain.restaurant.Restaurant;
import ru.liga.domain.exception.RestaurantNotFoundException;

import java.util.List;

public interface RestaurantService {

    Restaurant getRestaurantById(long id) throws RestaurantNotFoundException;

//    Restaurant getRestaurantByName(String Name) throws RestaurantNotFoundException;

    List<Restaurant> getAllDistinctRestaurants();

    List<Restaurant> getAllRestaurantsByRestaurantName(String name);

    void updateRestaurantName(String restaurantName, String newRestaurantName);

    void updateRestaurantStatusByRestaurantNameAndAddressId(String restaurantName, long addressId, String restaurantStatus);

    void createRestaurant(Restaurant restaurant);




}
