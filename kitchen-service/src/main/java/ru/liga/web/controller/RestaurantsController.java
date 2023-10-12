package ru.liga.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.liga.domain.restaurant.Restaurant;
import ru.liga.domain.exception.RestaurantNotFoundException;
import ru.liga.service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping("/restaurant-api/v1/restaurants")
@Validated
public class RestaurantsController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantsController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable long id) {
        try {
            Restaurant restaurant = restaurantService.getRestaurantById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(restaurant);
        } catch (RestaurantNotFoundException e) {
            //TODO логи
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/restaurants")
    public ResponseEntity<List<Restaurant>> getAllDistinctRestaurants() {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(restaurantService.getAllDistinctRestaurants());
    }




}
