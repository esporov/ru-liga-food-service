package ru.liga.service.impl;

import ru.liga.domain.enitity.orderService.order.Order;
import ru.liga.domain.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.repository.OrderRepository;
import ru.liga.service.OrderService;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;


    @Override
    public Order getOrderById(long orderId) {
        try {
            return orderRepository.findById(orderId)
                    .orElseThrow(()->new ResourceNotFoundException("Указанный заказ не найден"));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> getOrdersByCustomerId(long customerId) {
        return orderRepository.findOrdersByCustomerCustomerId(customerId);
    }

    @Override
    public List<Order> getOrdersByCourierId(long courierId) {
        return orderRepository.findOrdersByCourierCourierId(courierId);
    }

    @Override
    public List<Order> getOrdersByRestaurantId(long restaurantId) {
        return orderRepository.findOrdersByRestaurantId(restaurantId);
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }



}
