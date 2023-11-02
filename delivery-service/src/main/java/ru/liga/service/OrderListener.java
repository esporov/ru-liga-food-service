package ru.liga.service;

import ru.liga.interfaces.OrderWrapper;
import ru.liga.web.dto.order.OrderDto;
import ru.liga.web.dto.order.OrderItemDto;

public interface OrderListener {

    void receiveOrder(OrderWrapper<OrderDto, OrderItemDto> order);

}
