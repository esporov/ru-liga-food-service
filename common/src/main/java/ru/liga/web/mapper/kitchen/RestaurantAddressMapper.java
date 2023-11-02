package ru.liga.web.mapper.kitchen;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.liga.domain.enitity.kitchenService.restaurant.RestaurantAddress;
import ru.liga.web.dto.kitchen.RestaurantAddressDto;
import ru.liga.web.mapper.Mappable;


@Component
@Mapper(componentModel = "spring")
public interface RestaurantAddressMapper extends Mappable<RestaurantAddress, RestaurantAddressDto> {
}
