package ru.liga.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.interfaces.OrderWrapper;
import ru.liga.service.RabbitMqProducerService;
import ru.liga.web.dto.order.OrderDto;
import ru.liga.web.dto.order.OrderItemDto;

@Service
@RequiredArgsConstructor
@Transactional
public class RabbitMqProducerServiceImpl implements RabbitMqProducerService {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(OrderWrapper<OrderDto, OrderItemDto> order, String routingKey) {
        String str = String.format("JSON message send ->%s", order);
        System.out.println(str);
        rabbitTemplate.convertAndSend("KitchenDeliveryExchange", routingKey, order);
    }

}
