package ru.liga.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.domain.restaurant.Restaurant;
import ru.liga.domain.exception.RestaurantNotFoundException;
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
    public Restaurant getRestaurantById(long id) throws RestaurantNotFoundException {
        return restaurantRepository.getRestaurantById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found."));
    }

    /*@Override
    public Restaurant getRestaurantByName(String restaurantName) throws RestaurantNotFoundException {
        return restaurantRepository.findByRestaurantName(restaurantName)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found."));
    }*/

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
        restaurantRepository.updateRestaurantName(restaurantName, newRestaurantName);

    }

    @Override
    public void updateRestaurantStatusByRestaurantNameAndAddressId(String restaurantName,
                                                                   long addressId,
                                                                   String restaurantStatus) {
        restaurantRepository.updateRestaurantStatusByRestaurantNameAndAddressId(
                restaurantName,
                addressId,
                restaurantStatus);
    }

    @Override
    public void createRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }
}
