package ru.liga.web.dto.customer;

import lombok.Data;
import ru.liga.domain.enitity.orderService.order.OrderStatus;
import ru.liga.domain.enitity.orderService.order.TypeOfDelivery;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class CustomerOrderDto {

    @NotNull
    private long restaurantId;
    @NotNull
    private OrderStatus orderStatus;
    @NotNull
    private TypeOfDelivery typeOfDelivery;
    @NotNull
    private BigDecimal orderPrice;

}
