package ru.liga.controller;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.liga.domain.enitity.kitchenService.restaurant.RestaurantAddress;
import ru.liga.service.RestaurantServiceMyBatis;
import ru.liga.web.dto.kitchen.RestaurantAddressDto;
import ru.liga.web.dto.kitchen.RestaurantDto;
import ru.liga.web.mapper.kitchen.RestaurantAddressMapper;
import ru.liga.web.mapper.kitchen.RestaurantMapper;

import java.util.List;

@RestController
@RequestMapping("/restaurant-api/batis")
@RequiredArgsConstructor
@Hidden
public class MyBatisRestaurantController {
    private final RestaurantServiceMyBatis restaurantServiceMyBatis;
    private final RestaurantMapper restaurantMapper;
    private final RestaurantAddressMapper restaurantAddressMapper;

    @GetMapping("/v1.0/batis/{id}")
    public ResponseEntity<RestaurantDto> getRestaurant(@PathVariable("id") long id) {
        var rest = restaurantServiceMyBatis.getRestaurantById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(restaurantMapper.toDto(rest));
    }

    @GetMapping("/v1.0/addresses/city/{city}/status/{status}")
    public ResponseEntity<List<RestaurantAddressDto>> getAllRestaurantAddressByCityAndByStatus(
            @PathVariable(value = "city") String city,
            @PathVariable(value = "status") String status) {
        List<RestaurantAddress> addresses = restaurantServiceMyBatis.getAllRestaurantAddressByCityAndByStatus(
                city, status);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(restaurantAddressMapper.toDto(addresses));
    }
}
