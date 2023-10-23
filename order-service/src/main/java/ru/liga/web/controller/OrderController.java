package ru.liga.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.liga.service.OrderService;
import ru.liga.web.mapper.OrderMapper;
import ru.liga.web.dto.order.OrderDto;

import java.util.List;

@RestController
@RequestMapping("/order-api")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

   /* @GetMapping("/order")
    public ResponseEntity<OrderDto> getOrderById(@RequestParam("id") long id) {
        var order = orderService.getOrderById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(orderMapper.toDto(order));
    }*/

    @GetMapping("/order")
    public ResponseEntity<List<OrderDto>> getOrdersByCustomerId(@RequestParam("customerId") long customerId) {
        var orders = orderService.getOrdersByCustomerId(customerId);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(orderMapper.toDto(orders));
    }
}
