package ru.liga.web.mapper;

import ru.liga.domain.enitity.kitchenService.restaurant.RestaurantAddress;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.liga.web.dto.kitchen.RestaurantAddressDto;


@Component
@Mapper(componentModel = "spring")
public interface RestaurantAddressMapper extends Mappable<RestaurantAddress, RestaurantAddressDto> {
}
