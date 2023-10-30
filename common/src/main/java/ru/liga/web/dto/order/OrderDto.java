package ru.liga.web.dto.order;

import ru.liga.domain.enitity.orderService.order.OrderStatus;
import ru.liga.domain.enitity.orderService.order.TypeOfDelivery;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderDto implements Serializable {

    private long restaurantId;

    private TypeOfDelivery typeOfDelivery;

    private BigDecimal orderPrice;

}
