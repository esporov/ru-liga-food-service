package ru.liga.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.liga.util.OrderWrapper;
import ru.liga.web.dto.order.OrderDto;
import ru.liga.web.dto.order.OrderItemDto;

@Component
@FeignClient(name = "notification-service", url = "http://localhost:8082/notification-service")
public interface NotificationClient {

    @PostMapping("/kitchenDelivery")
    OrderWrapper<OrderDto, OrderItemDto> sendMessage(@RequestBody OrderWrapper<OrderDto, OrderItemDto> order,
                                                     @RequestParam("routingKey") String routingKey);
}
