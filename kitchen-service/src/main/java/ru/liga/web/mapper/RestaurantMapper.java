package ru.liga.web.mapper;

import ru.liga.domain.enitity.kitchenService.restaurant.Restaurant;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.liga.web.dto.kitchen.RestaurantDto;


@Component
@Mapper(componentModel = "spring")
public interface RestaurantMapper extends Mappable<Restaurant, RestaurantDto> {
}
