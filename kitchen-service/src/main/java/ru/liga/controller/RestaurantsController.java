package ru.liga.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.liga.domain.enitity.kitchenService.restaurant.Restaurant;
import ru.liga.domain.enitity.kitchenService.restaurant.RestaurantAddress;
import ru.liga.domain.exception.ExceptionBody;
import ru.liga.service.RestaurantService;
import ru.liga.web.dto.kitchen.RestaurantAddressDto;
import ru.liga.web.dto.kitchen.RestaurantDto;
import ru.liga.web.mapper.kitchen.RestaurantAddressMapper;
import ru.liga.web.mapper.kitchen.RestaurantMapper;

import java.util.List;

@Tag(name = "Restaurant Controller")
@RestController
@RequestMapping("/restaurant-api")
@RequiredArgsConstructor
@Validated
public class RestaurantsController {

    private final Logger LOGGER = LoggerFactory.getLogger(RestaurantsController.class);

    private final RestaurantService restaurantService;
    private final RestaurantMapper restaurantMapper;
    private final RestaurantAddressMapper restaurantAddressMapper;

    @Operation(summary = "Получить все рестораны.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Успешный запрос",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Некорректный запрос",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ExceptionBody.class)))
            })
    @GetMapping("/v1.0/restaurants")
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants() {
        LOGGER.info("Выполняем GET запрос по выводу списка всех ресторанов");
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(restaurantMapper.toDto(restaurants));
    }

    @Operation(summary = "Получить ресторан по id.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Успешный запрос",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Некорректный запрос",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ExceptionBody.class)))
            })
    @GetMapping("/v1.0/restaurant/id/{id}")
    public ResponseEntity<RestaurantDto> getRestaurantByRestaurantId(@PathVariable(value = "id") long id) {
        LOGGER.info("Выполняем GET запрос по поиску ресторана по id = {}", id);
        Restaurant restaurant = restaurantService.getRestaurantByRestaurantId(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(restaurantMapper.toDto(restaurant));
    }

    @Operation(summary = "Получить все адреса по id ресторана.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Успешный запрос",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Некорректный запрос",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ExceptionBody.class)))
            })
    @GetMapping("/v1.0/addresses/restaurantId/{id}")
    public ResponseEntity<List<RestaurantAddressDto>> getAllRestaurantAddressesByRestaurantId(
            @PathVariable(value = "id") long id) {
        List<RestaurantAddress> addresses = restaurantService.getAllRestaurantAddressesByRestaurantId(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(restaurantAddressMapper.toDto(addresses));
    }

    @Operation(summary = "Получить все адреса по названию ресторана.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Успешный запрос",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Некорректный запрос",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ExceptionBody.class)))
            })
    @GetMapping("/v1.0/addresses/restaurantName/{name}")
    public ResponseEntity<List<RestaurantAddressDto>> getAllRestaurantAddressesByRestaurantName(
            @PathVariable(value = "name") String name) {
        List<RestaurantAddress> addresses = restaurantService.getAllRestaurantAddressesByRestaurantName(name);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(restaurantAddressMapper.toDto(addresses));
    }

    @Operation(summary = "Получить все адреса по id ресторана и статусу.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Успешный запрос",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Некорректный запрос",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ExceptionBody.class)))
            })
    @GetMapping("/v1.0/addresses")
    public ResponseEntity<List<RestaurantAddressDto>> getAllRestaurantAddressByRestaurantIdAndRestaurantStatus(
            @RequestParam("restaurantId") long restaurantId,
            @RequestParam("status") String restaurantStatus) {
        List<RestaurantAddress> addresses = restaurantService.getAllRestaurantAddressByRestaurantIdAndRestaurantStatus(
                restaurantId, restaurantStatus);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(restaurantAddressMapper.toDto(addresses));
    }

    @Operation(summary = "Обновить статус адреса по id адреса.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Успешный запрос",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Некорректный запрос",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ExceptionBody.class)))
            })
    @PatchMapping("/v1.0/address/updateStatus")
    public ResponseEntity<RestaurantAddressDto> updateRestaurantAddressStatusByAddressId(
            @RequestParam(value = "restaurantId") long id,
            @RequestParam(value = "newStatus") String restaurantStatus) {
        RestaurantAddress address = restaurantService.updateRestaurantAddressStatusByAddressId(id, restaurantStatus);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(restaurantAddressMapper.toDto(address));
    }

    @Operation(summary = "Создать новый ресторан.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Успешный запрос",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Некорректный запрос",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ExceptionBody.class)))
            })
    @PostMapping("/v1.0/restaurant")
    public ResponseEntity<RestaurantDto> createRestaurant(@Validated @RequestBody RestaurantDto restaurant,
                                                          @Validated @RequestBody RestaurantAddressDto addressDto) {
        var newRestaurant = restaurantService.createRestaurant(restaurantMapper.toEntity(restaurant));
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(restaurantMapper.toDto(newRestaurant));
    }

    @Operation(summary = "Создать новый адрес для ресторана по ид.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Успешный запрос",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Некорректный запрос",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ExceptionBody.class)))
            })
    @PostMapping("/v1.0/restaurant/id/{id}/address")
    public ResponseEntity<RestaurantAddressDto> createRestaurantAddressByRestaurantId(
            @PathVariable("id") long id, @Validated @RequestBody RestaurantAddressDto addressDto) {
        var address = restaurantService.createRestaurantAddressByRestaurantId(
                id, restaurantAddressMapper.toEntity(addressDto));
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(restaurantAddressMapper.toDto(address));
    }
}
