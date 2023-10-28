package ru.liga.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.liga.interfaces.OrderWrapper;
import ru.liga.service.RabbitMqProducerService;
import ru.liga.web.dto.order.OrderDto;
import ru.liga.web.dto.order.OrderItemDto;

@RestController
@RequestMapping("/notification-service")
@RequiredArgsConstructor
public class NotificationController {

    private final RabbitMqProducerService rabbitMqProducerService;

    @PostMapping("/kitchenDelivery")
    public void sendOrderToKitchenDeliveryExchanger(
            @RequestBody OrderWrapper<OrderDto, OrderItemDto> order, @RequestParam("routingKey") String routingKey) {
        rabbitMqProducerService.sendMessage(order, routingKey);
    }
}
