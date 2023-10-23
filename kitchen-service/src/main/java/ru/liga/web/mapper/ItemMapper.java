package ru.liga.web.mapper;

import domain.enitity.kitchenService.item.Item;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import web.dto.kitchen.ItemDto;
import web.mapper.Mappable;

@Component
@Mapper(componentModel = "spring")
public interface ItemMapper extends Mappable<Item, ItemDto> {
}
