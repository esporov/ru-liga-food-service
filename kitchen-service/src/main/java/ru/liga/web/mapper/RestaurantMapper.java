package ru.liga.web.mapper;

import domain.enitity.kitchenService.restaurant.Restaurant;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import web.dto.kitchen.RestaurantDto;
import web.mapper.Mappable;


@Component
@Mapper(componentModel = "spring")
public interface RestaurantMapper extends Mappable<Restaurant, RestaurantDto> {
}
