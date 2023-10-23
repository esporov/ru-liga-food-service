package ru.liga.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.liga.domain.restaurant.Restaurant;
import ru.liga.domain.restaurant.RestaurantAddress;
import ru.liga.service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping("/restaurant-api/v1/")
public class RestaurantsController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantsController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("restaurant/{id}")
    public Restaurant getRestaurantByRestaurantId(@PathVariable(value = "id") long id) {
        return restaurantService.getRestaurantByRestaurantId(id);
    }

    @GetMapping("restaurant/{id}/restaurants")
    public ResponseEntity<List<RestaurantAddress>> getAllRestaurantsByRestaurantId(@PathVariable(value = "id") long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(restaurantService.getAllRestaurantsByRestaurantId(id));
    }

    @GetMapping("/restaurants")
    public ResponseEntity<List<Restaurant>> getAllDistinctRestaurants() {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(restaurantService.getAllDistinctRestaurants());
    }

    @PatchMapping("/restaurants/")
    public String updateRestaurantStatusByAddressId(@RequestParam(value = "id") long id,
                                                    @RequestParam(value = "restaurantStatus") String restaurantStatus) {
        try {
            restaurantService.updateRestaurantStatusByAddressId(id, restaurantStatus);
            return "id= " + id + " restaurantStatus=" + restaurantStatus;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*@GetMapping("/addressStatus/{restaurantStatus}")
    public ResponseEntity<List<RestaurantAddress>> getRestaurantByRestaurantStatus(
            @PathVariable(value = "restaurantStatus") String restaurantStatus) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(restaurantService.getRestaurantByRestaurantStatus(restaurantStatus));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/
}
