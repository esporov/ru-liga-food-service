package ru.liga.web.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.liga.domain.item.Item;
import ru.liga.domain.restaurant.RestaurantAddress;
import ru.liga.web.dto.ItemDto;
import ru.liga.web.dto.RestaurantAddressDto;

@Component
@Mapper(componentModel = "spring")
public interface RestaurantAddressMapper extends Mappable<RestaurantAddress, RestaurantAddressDto>{
}
