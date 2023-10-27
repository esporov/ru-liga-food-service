package ru.liga.web.mapper;

import ru.liga.domain.enitity.kitchenService.item.Item;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.liga.web.dto.kitchen.ItemDto;

@Component
@Mapper(componentModel = "spring")
public interface ItemMapper extends Mappable<Item, ItemDto> {
}
