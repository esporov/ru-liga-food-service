package ru.liga.service;

import domain.enitity.orderService.order.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderService {

    Order getOrderById(long orderId);

    List<Order> getOrdersByCustomerId(long customerId);

    List<Order> getOrdersByCourierId(long courierId);

    List<Order> getOrdersByRestaurantId(long restaurantId);

    Order createOrder(Order order);


}
