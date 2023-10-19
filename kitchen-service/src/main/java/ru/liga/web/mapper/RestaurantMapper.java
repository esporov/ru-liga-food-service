package ru.liga.web.mapper;

import lombok.extern.apachecommons.CommonsLog;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.liga.domain.restaurant.Restaurant;
import ru.liga.web.dto.RestaurantDto;

@Component
@Mapper(componentModel = "spring")
public interface RestaurantMapper extends Mappable<Restaurant, RestaurantDto> {
}
