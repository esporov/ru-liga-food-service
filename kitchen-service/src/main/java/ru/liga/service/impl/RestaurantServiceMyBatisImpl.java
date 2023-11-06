package ru.liga.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.batisMapper.RestaurantMapperBatis;
import ru.liga.domain.enitity.kitchenService.restaurant.Restaurant;
import ru.liga.domain.enitity.kitchenService.restaurant.RestaurantAddress;
import ru.liga.domain.enitity.kitchenService.restaurant.RestaurantStatus;
import ru.liga.domain.exception.RestaurantNotFoundException;
import ru.liga.service.RestaurantServiceMyBatis;
import ru.liga.util.IllegalStatusExceptionMessage;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantServiceMyBatisImpl implements RestaurantServiceMyBatis, IllegalStatusExceptionMessage {

    private final RestaurantMapperBatis restaurantMapperBatis;

    @Override
    public Restaurant getRestaurantById(long id) {
        return restaurantMapperBatis.getRestaurantById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Ресторан не найдеен"));
    }

    @Override
    public List<RestaurantAddress> getAllRestaurantAddressByCityAndByStatus(String city, String restaurantStatus) {
        return restaurantMapperBatis
                .getAllRestaurantAddressByCityAndByStatus(city, RestaurantStatus.valueOf(restaurantStatus));
    }
}
