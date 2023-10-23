package ru.liga.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.liga.domain.enitity.orderService.order.Order;

import java.util.List;

@FeignClient(name = "core-service", url = "http://localhost:8083")
public interface CoreFeign {

    @GetMapping("/order-api/order?customerId={id}")
    List<Order> getOrders(@PathVariable("id") long customerId);
}
