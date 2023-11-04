package ru.liga.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
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
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, responseEntity.getHeaders().getContentType());
        assertEquals(addressDto,responseEntity.getBody());
    }
}