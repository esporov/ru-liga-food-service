package ru.liga.web.mapper.order;

import org.springframework.stereotype.Component;
import ru.liga.domain.enitity.kitchenService.item.Item;
import ru.liga.domain.enitity.orderService.orderItem.OrderItem;
import ru.liga.web.dto.order.OrderItemDto;
import ru.liga.web.mapper.Mappable;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderItemMapper implements Mappable<OrderItem, OrderItemDto> {


    @Override
    public OrderItemDto toDto(OrderItem entity) {
        return OrderItemDto
                .builder()
                .itemId(entity.getItem().getItemId())
                .quantity(entity.getQuantity())
                .build();
    }

    @Override
    public List<OrderItemDto> toDto(List<OrderItem> entityList) {
        return entityList.stream()
                .map(e-> OrderItemDto
                        .builder()
                        .itemId(e.getItem().getItemId())
                        .quantity(e.getQuantity())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public OrderItem toEntity(OrderItemDto dto) {
        var orderItem = new OrderItem();
        orderItem.setQuantity(dto.getQuantity());
        orderItem.setItem(Item
                .builder()
                .itemId(dto.getItemId())
                .build());
        return orderItem;
    }

    @Override
    public List<OrderItem> toEntity(List<OrderItemDto> dtoList) {
        return dtoList.stream()
                .map(d-> {
                    var orderItem = new OrderItem();
                    orderItem.setQuantity(d.getQuantity());
                    orderItem.setItem(Item
                            .builder()
                            .itemId(d.getItemId())
                            .build());
                    return orderItem;
                })
                .collect(Collectors.toList());
    }
}
