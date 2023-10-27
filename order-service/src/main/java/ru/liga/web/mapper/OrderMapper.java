package ru.liga.web.mapper;

import ru.liga.domain.enitity.orderService.order.Order;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.liga.web.dto.order.OrderDto;

@Component
@Mapper(componentModel = "spring")
public interface OrderMapper extends Mappable<Order, OrderDto> {
}
