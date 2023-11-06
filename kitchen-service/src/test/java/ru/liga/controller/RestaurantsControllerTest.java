package ru.liga.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import ru.liga.domain.enitity.kitchenService.restaurant.Restaurant;
import ru.liga.domain.enitity.kitchenService.restaurant.RestaurantAddress;
import ru.liga.domain.enitity.kitchenService.restaurant.RestaurantStatus;
import ru.liga.service.RestaurantService;
import ru.liga.web.dto.kitchen.RestaurantAddressDto;
import ru.liga.web.mapper.kitchen.RestaurantAddressMapper;

import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestaurantsControllerTest {

    private final Logger LOGGER = LoggerFactory.getLogger(RestaurantsControllerTest.class);

    @Mock
    RestaurantService restaurantService;

    @Mock
    RestaurantAddressMapper restaurantAddressMapper;

    @InjectMocks
    RestaurantsController restaurantsController;

    @Test
    @DisplayName("PATCH /v1.0/address/updateStatus возвращает HTTP-ответ со статусом 200 OK и с обновленным адресом")
    void updateRestaurantAddressStatusByAddressId_validStatusValidId_returnsValidResponseEntity() {
        //given
        var restaurant = new Restaurant(1, "КФЦ");
        var address = new RestaurantAddress(
                1, "ул. Бетанкура, д. 1", "Нижний Новгород",
                Date.from(Instant.now()), RestaurantStatus.ACTIVE, restaurant);
        var addressDto = new RestaurantAddressDto(
                address.getStreetName(), address.getCity(), address.getRestaurantStatus(), address.getDateOfAdd());

        when(restaurantService.updateRestaurantAddressStatusByAddressId(
                address.getAddressId(), address.getRestaurantStatus().toString())).thenReturn(address);

        when(restaurantAddressMapper.toDto(address)).thenReturn(addressDto);

        //when
        var responseEntity = this.restaurantsController.updateRestaurantAddressStatusByAddressId(
                address.getAddressId(), address.getRestaurantStatus().toString());

        //then
        assertNotNull(responseEntity);
        LOGGER.debug("Проверка на NotNul пройдена");
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        LOGGER.debug("Проверка на HTTP OK пройдена");
        assertEquals(MediaType.APPLICATION_JSON, responseEntity.getHeaders().getContentType());
        LOGGER.debug("Проверка на MediaType пройдена");
        assertEquals(addressDto,responseEntity.getBody());
        LOGGER.debug("Проверка на ResponseBody пройдена");
    }
}