package ru.liga.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.liga.client.NotificationClient;
import ru.liga.domain.enitity.orderService.order.Order;
import ru.liga.domain.enitity.orderService.orderItem.OrderItem;
import ru.liga.util.OrderWrapper;
import ru.liga.service.OrderService;
import ru.liga.web.dto.customer.CustomerOrderDto;
import ru.liga.web.dto.order.OrderDto;
import ru.liga.web.dto.order.OrderItemDto;
import ru.liga.web.mapper.customer.CustomerOrderMapper;
import ru.liga.web.mapper.order.OrderItemMapper;
import ru.liga.web.mapper.order.OrderMapper;

import java.util.List;

@RestController
@RequestMapping("/order-service/order-api")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final CustomerOrderMapper customerOrderMapper;
    private final OrderItemMapper orderItemMapper;
    private final NotificationClient notificationClient;

    @GetMapping("v1.0/order/id/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("id") long id) {
        var order = orderService.getOrderByOrderId(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(orderMapper.toDto(order));
    }

    @PostMapping("/v1.0/order")
    public ResponseEntity<OrderWrapper<OrderDto, OrderItemDto>> createOrderByCustomerIdAndRestaurantIdAndTypeOfDelivery(
            @RequestParam("customerId") long customerId,
            @RequestParam("restaurantId") long restaurantId,
            @RequestParam("typeOfDelivery") String typeOfDelivery,
            @RequestBody List<OrderItemDto> items) {
        OrderWrapper<Order,OrderItem> fullOrder =
                orderService.createOrderByCustomerIdAndRestaurantIdAndTypeOfDelivery(
                        customerId, restaurantId, typeOfDelivery, orderItemMapper.toEntity(items));

        OrderWrapper<OrderDto,OrderItemDto> fullOrderDto = new OrderWrapper<>();
        fullOrderDto.setOrder(orderMapper.toDto(fullOrder.getOrder()));
        fullOrderDto.setItems(orderItemMapper.toDto(fullOrder.getItems()));

        notificationClient.sendMessage(fullOrderDto, "delivery");

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(fullOrderDto);
    }

    @GetMapping("/v1.0/orders/customerId/{id}")
    public ResponseEntity<List<CustomerOrderDto>> getOrdersByCustomerId(@PathVariable("id") long customerId) {
        var orders = orderService.getOrdersByCustomerId(customerId);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(customerOrderMapper.toDto(orders));
    }

}
