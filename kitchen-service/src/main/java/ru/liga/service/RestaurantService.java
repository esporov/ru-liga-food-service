package ru.liga.service;


import ru.liga.domain.enitity.kitchenService.restaurant.Restaurant;
import ru.liga.domain.enitity.kitchenService.restaurant.RestaurantAddress;

import java.util.List;

public interface RestaurantService {

    Restaurant getRestaurantByRestaurantId(long id);

    RestaurantAddress getRestaurantAddressByAddressId(long id);

    List<Restaurant> getAllRestaurants();

    List<RestaurantAddress> getAllRestaurantAddressesByRestaurantId(long id);

    List<RestaurantAddress> getAllRestaurantAddressesByRestaurantName(String restaurantName);

    List<RestaurantAddress> getRestaurantAddressesByRestaurantIdAndRestaurantStatus(long restaurantId, String restaurantStatus);

    RestaurantAddress updateRestaurantAddressStatusByAddressId(long addressId, String restaurantStatus);


    void createRestaurant(Restaurant restaurant);
}
