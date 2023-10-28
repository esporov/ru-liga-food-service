package ru.liga.web.mapper.kitchen;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.liga.domain.enitity.kitchenService.restaurant.Restaurant;
import ru.liga.web.dto.kitchen.RestaurantDto;
import ru.liga.web.mapper.Mappable;


@Component
@Mapper(componentModel = "spring")
public interface RestaurantMapper extends Mappable<Restaurant, RestaurantDto> {
}
