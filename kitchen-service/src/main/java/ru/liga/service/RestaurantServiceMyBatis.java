package ru.liga.service;

import ru.liga.domain.enitity.kitchenService.restaurant.Restaurant;
import ru.liga.domain.enitity.kitchenService.restaurant.RestaurantAddress;

import java.util.List;

public interface RestaurantServiceMyBatis {

    Restaurant getRestaurantById(long id);

    List<RestaurantAddress> getAllRestaurantAddressByCityAndByStatus(String city, String restaurantStatus);
}
