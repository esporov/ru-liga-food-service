package ru.liga.repository;

import ru.liga.domain.enitity.orderService.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


    List<Order> findOrdersByCustomerCustomerId(long orderId);

    List<Order> findOrdersByCourierCourierId(long courierId);
    List<Order> findOrdersByRestaurantId(long restaurantId);



}
