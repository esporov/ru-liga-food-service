package ru.liga.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.domain.enitity.orderService.orderItem.OrderItem;
import ru.liga.domain.exception.OrderItemNotFoundException;
import ru.liga.repository.OrderItemRepository;
import ru.liga.service.OrderItemService;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
//    private final OrderService orderService;

    @Override
    public OrderItem getOrderItemByOrderItemId(long orderItemId) {
        return orderItemRepository.findById(orderItemId)
                .orElseThrow(() -> new OrderItemNotFoundException(
                        "Позиция заказа по id = " + orderItemId + " не найдена."));
    }

    /*@Override
    public List<OrderItem> getAllOrderItemByOrderId(long orderId) {
        orderService.getOrderByOrderId(orderId);
        var orderList = orderItemRepository.getAllOrderItemByOrderId(orderId);
        if (orderList.size() == 0) {
            throw new OrderItemNotFoundException("Список заказа пуст");
        }
        return orderList;
    }*/

    @Transactional
    @Override
    public List<OrderItem> createOrderItems(List<OrderItem> items) {
        return orderItemRepository.saveAll(items);
    }
}
