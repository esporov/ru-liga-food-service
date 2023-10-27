package ru.liga.service;

import ru.liga.domain.enitity.orderService.order.Order;

import java.util.List;

public interface OrderService {

    Order getOrderById(long orderId);

    List<Order> getOrdersByCustomerId(long customerId);

    List<Order> getOrdersByCourierId(long courierId);

    List<Order> getOrdersByRestaurantId(long restaurantId);

    Order createOrder(Order order);


}
