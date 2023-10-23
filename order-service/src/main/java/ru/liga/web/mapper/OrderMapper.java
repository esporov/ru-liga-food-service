package ru.liga.web.mapper;

import domain.enitity.orderService.order.Order;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import web.dto.order.OrderDto;
import web.mapper.Mappable;

@Component
@Mapper(componentModel = "spring")
public interface OrderMapper extends Mappable<Order, OrderDto> {
}
