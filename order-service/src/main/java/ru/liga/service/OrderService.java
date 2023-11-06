package ru.liga.service;

import ru.liga.domain.enitity.orderService.order.Order;
import ru.liga.domain.enitity.orderService.orderItem.OrderItem;
import ru.liga.util.OrderWrapper;

import java.util.List;

public interface OrderService {

    Order getOrderByOrderId(long orderId);

    List<Order> getOrdersByCustomerId(long customerId);

    List<Order> getOrdersByCourierId(long courierId);

    List<Order> getOrdersByRestaurantId(long restaurantId);

    Order createOrder(Order order);

    OrderWrapper<Order,OrderItem> createOrderByCustomerIdAndRestaurantIdAndTypeOfDelivery(
            long customerId, long restaurantId, String typeOfDelivery, List<OrderItem> items);



}
