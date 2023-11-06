package ru.liga.web.mapper.order;

import ru.liga.domain.enitity.orderService.order.Order;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.liga.web.dto.order.OrderDto;
import ru.liga.web.mapper.Mappable;

@Component
@Mapper(componentModel = "spring")
public interface OrderMapper extends Mappable<Order, OrderDto> {
}
