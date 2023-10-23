package ru.liga.web.mapper;

import domain.enitity.kitchenService.restaurant.RestaurantAddress;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import web.dto.kitchen.RestaurantAddressDto;
import web.mapper.Mappable;


@Component
@Mapper(componentModel = "spring")
public interface RestaurantAddressMapper extends Mappable<RestaurantAddress, RestaurantAddressDto> {
}
