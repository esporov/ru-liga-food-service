package ru.liga.web.dto.order;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class OrderItemDto implements Serializable {

    private long itemId;

    private int quantity;
}
