package ru.liga.web.controller;


import ru.liga.web.mapper.RestaurantAddressMapper;
import ru.liga.web.mapper.RestaurantMapper;
import web.dto.kitchen.RestaurantAddressDto;
import web.dto.kitchen.RestaurantDto;
import domain.enitity.kitchenService.restaurant.Restaurant;
import domain.enitity.kitchenService.restaurant.RestaurantAddress;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.liga.service.RestaurantService;
import java.util.List;

@Tag(name = "Restaurant Controller")
@RestController
@RequestMapping("/restaurant-api")
@RequiredArgsConstructor
public class RestaurantsController {

    private final RestaurantService restaurantService;
    private final RestaurantMapper restaurantMapper;
    private final RestaurantAddressMapper restaurantAddressMapper;

    @Operation(summary = "Получить все рестораны.")
    @GetMapping("/v1.0/restaurants")
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants() {
        List<Restaurant> restaurants =restaurantService.getAllRestaurants();
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(restaurantMapper.toDto(restaurants));
    }
    @Operation(summary = "Получить ресторан по id.")
    @GetMapping("/v1.0/restaurant/id/{id}")
    public ResponseEntity<RestaurantDto> getRestaurantByRestaurantId(@PathVariable(value = "id") long id) {
        Restaurant restaurant = restaurantService.getRestaurantByRestaurantId(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(restaurantMapper.toDto(restaurant));
    }

    @Operation(summary = "Получить все адреса по id ресторана.")
    @GetMapping("/v1.0/restaurants/restaurantId/{id}")
    public ResponseEntity<List<RestaurantAddressDto>> getAllRestaurantAddressesByRestaurantId(
            @PathVariable(value = "id") long id) {
        List<RestaurantAddress> addresses = restaurantService.getAllRestaurantAddressesByRestaurantId(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(restaurantAddressMapper.toDto(addresses));
    }
    @Operation(summary = "Получить все адреса по названию ресторана.")
    @GetMapping("/v1.0/restaurants/restaurantName/{name}")
    public ResponseEntity<List<RestaurantAddressDto>> getAllRestaurantAddressesByRestaurantName(
            @PathVariable(value = "name") String name) {
        List<RestaurantAddress> addresses = restaurantService.getAllRestaurantAddressesByRestaurantName(name);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(restaurantAddressMapper.toDto(addresses));
    }

    @Operation(summary = "Получить все адреса по id ресторана и статусу.")
    @GetMapping("/v1.0/addresses")
    public ResponseEntity<List<RestaurantAddressDto>> getRestaurantAddressesByRestaurantIdAndRestaurantStatus(
            @RequestParam("restaurantId") long restaurantId,
            @RequestParam("status") String restaurantStatus) {
        List<RestaurantAddress> addresses = restaurantService.getRestaurantAddressesByRestaurantIdAndRestaurantStatus(
                restaurantId, restaurantStatus);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(restaurantAddressMapper.toDto(addresses));
    }

    @Operation(summary = "Обновить статус адреса по id ресторана.")
    @PatchMapping("/v1.0/address")
    public ResponseEntity<RestaurantAddressDto> updateRestaurantAddressStatusByAddressId(
            @RequestParam(value = "id") long id,
            @RequestParam(value = "restaurantStatus") String restaurantStatus) {
        RestaurantAddress address = restaurantService.updateRestaurantAddressStatusByAddressId(id, restaurantStatus);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(restaurantAddressMapper.toDto(address));
    }


}
