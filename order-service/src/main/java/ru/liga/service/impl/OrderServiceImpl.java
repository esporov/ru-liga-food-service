package ru.liga.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.client.KitchenFeign;
import ru.liga.domain.enitity.kitchenService.item.Item;
import ru.liga.domain.enitity.orderService.customer.Customer;
import ru.liga.domain.enitity.orderService.order.Order;
import ru.liga.domain.enitity.orderService.order.OrderStatus;
import ru.liga.domain.enitity.orderService.order.TypeOfDelivery;
import ru.liga.domain.enitity.orderService.orderItem.OrderItem;
import ru.liga.domain.exception.IllegalStatusException;
import ru.liga.domain.exception.OrderNotFoundException;
import ru.liga.util.IllegalStatusExceptionMessage;
import ru.liga.util.OrderWrapper;
import ru.liga.repository.OrderRepository;
import ru.liga.service.CustomerService;
import ru.liga.service.OrderItemService;
import ru.liga.service.OrderService;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService, IllegalStatusExceptionMessage {

    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final KitchenFeign kitchenFeign;
    private final OrderItemService orderItemService;


    @Override
    public Order getOrderByOrderId(long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(
                        "Заказ по id = " + orderId + " не найден."));
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

    @Transactional
    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }


    @Transactional
    @Override
    public OrderWrapper<Order,OrderItem>  createOrderByCustomerIdAndRestaurantIdAndTypeOfDelivery(
            long customerId, long restaurantId, String typeOfDelivery, List<OrderItem> items) {
        //Поиск клиента по ид
        var customer = customerService.getCustomerById(customerId);

        //Преобразование OrderItem
        List<OrderItem> newItems = new ArrayList<>();
        BigDecimal price = BigDecimal.ZERO;
        for (OrderItem orderItem : items) {
            long itemId = orderItem.getItem().getItemId();
            Item menuItem = kitchenFeign.getItemByItemId(itemId);
            OrderItem newItem = OrderItem.builder()
                    .item(menuItem)
                    .quantity(orderItem.getQuantity())
                    .price(menuItem.getItemPrice())
                    .build();
            newItems.add(newItem);
            //Вычисляем суммарную стоимость заказа
            price = price.add(menuItem.getItemPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity())));
        }

        //Создание Order
        var order = createOrderByCustomerAndRestaurantIdAndTypeOfDeliveryAndPrice(
                customer, restaurantId, typeOfDelivery, price);

        //Добавление к позициям заказа - заказ Order (связываем с его ид)
        for (OrderItem item : newItems) {
            item.setOrder(order);
        }

        //Создание orderItem
        newItems = orderItemService.createOrderItems(newItems); // <-------------тут вылетает
        OrderWrapper<Order,OrderItem> fullOrder = new OrderWrapper<>();
        fullOrder.setOrder(order);
        fullOrder.setItems(newItems);
        return fullOrder;
    }
    private Order createOrderByCustomerAndRestaurantIdAndTypeOfDeliveryAndPrice(
            Customer customer, long restaurantId, String typeOfDelivery, BigDecimal price) {
        try {
            TypeOfDelivery.valueOf(typeOfDelivery);
        } catch (IllegalArgumentException e) {
            throw new IllegalStatusException(exceptionMessage(TypeOfDelivery.class), e);
        }
        var order = Order.builder()
                .customer(customer)
                .restaurantId(restaurantId)
                .orderStatus(OrderStatus.NOT_ACCEPTED_YET)
                .typeOfDelivery(TypeOfDelivery.valueOf(typeOfDelivery))
                .createDate(Date.from(Instant.now()))
                .orderPrice(price)
                .build();
        return createOrder(order);
    }
}
