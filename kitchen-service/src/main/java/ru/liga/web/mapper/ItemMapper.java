package ru.liga.web.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.liga.domain.item.Item;
import ru.liga.web.dto.ItemDto;
@Component
@Mapper(componentModel = "spring")
public interface ItemMapper extends Mappable<Item, ItemDto>{
}
