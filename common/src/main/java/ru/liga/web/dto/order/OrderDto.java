package ru.liga.web.dto.order;

import ru.liga.domain.enitity.orderService.order.OrderStatus;
import ru.liga.domain.enitity.orderService.order.TypeOfDelivery;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderDto {

    private long restaurantId;

    private TypeOfDelivery typeOfDelivery;

    private OrderStatus orderStatus;

    private BigDecimal orderPrice;

    private Date createDate;


}
