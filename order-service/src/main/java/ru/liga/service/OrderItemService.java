package ru.liga.service;

import ru.liga.domain.enitity.orderService.orderItem.OrderItem;

import java.util.List;

public interface OrderItemService {

    OrderItem getOrderItemByOrderItemId(long orderItemId);
//    List<OrderItem> getAllOrderItemByOrderId(long orderId);

    List<OrderItem> createOrderItems(List<OrderItem> items);
}
