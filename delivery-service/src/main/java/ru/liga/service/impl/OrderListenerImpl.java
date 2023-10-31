package ru.liga.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.domain.enitity.deliveryService.courier.CourierStatus;
import ru.liga.domain.exception.CourierNotFoundException;
import ru.liga.interfaces.OrderWrapper;
import ru.liga.service.CourierService;
import ru.liga.service.OrderListener;
import ru.liga.web.dto.order.OrderDto;
import ru.liga.web.dto.order.OrderItemDto;

import java.util.concurrent.TimeUnit;


@Service
@RequiredArgsConstructor
@Slf4j
public class OrderListenerImpl implements OrderListener {

    private final Logger LOGGER = LoggerFactory.getLogger(OrderListenerImpl.class);

    private volatile boolean isListeningEnabled = true;
    private final CourierService courierService;

    @Transactional(readOnly = true)
    @RabbitListener(queues = "delivery", returnExceptions = "false")
    public void receiveOrder(OrderWrapper<OrderDto, OrderItemDto> order) {
        if (isListeningEnabled) {
            try {
                courierService.getAllCourierByCourierStatus(CourierStatus.FREE.name());
                //TODO логика по поиску подходящего курьера
                LOGGER.info("Заказ передан курьеру с id = " + " , заказ: " + order);
            } catch (CourierNotFoundException e) {
                isListeningEnabled = false;
                LOGGER.info("Доступных курьеров нет");
            }
        } else {
            //Выбрасываем чтобы не потерять сообщение (по другому никак не получилось)
            throw new CourierNotFoundException();
        }
    }

    //Вызываем каждую минуту для проверки свободных курьеров
    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    private void enableListeningAfterDelay() {
        if (!isListeningEnabled) {
            isListeningEnabled = true;
        }
    }
}
