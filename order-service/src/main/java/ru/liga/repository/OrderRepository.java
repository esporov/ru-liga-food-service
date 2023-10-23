package ru.liga.repository;

import domain.enitity.orderService.order.Order;
import domain.enitity.orderService.order.OrderStatus;
import domain.exception.ResourceNotFoundException;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


    List<Order> findOrdersByCustomerCustomerId(long orderId);

    List<Order> findOrdersByCourierCourierId(long courierId);
    List<Order> findOrdersByRestaurantId(long restaurantId);



}
