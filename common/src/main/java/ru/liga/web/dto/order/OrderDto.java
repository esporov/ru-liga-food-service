package ru.liga.web.dto.order;

import lombok.*;
import ru.liga.domain.enitity.orderService.order.TypeOfDelivery;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto implements Serializable {

    private long restaurantId;

    private TypeOfDelivery typeOfDelivery;

    private BigDecimal orderPrice;

    @Override
    public String toString() {
        return "OrderDto{" +
                "restaurantId=" + restaurantId +
                ", typeOfDelivery=" + typeOfDelivery +
                ", orderPrice=" + orderPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDto orderDto = (OrderDto) o;

        if (restaurantId != orderDto.restaurantId) return false;
        if (typeOfDelivery != orderDto.typeOfDelivery) return false;
        return Objects.equals(orderPrice, orderDto.orderPrice);
    }

    @Override
    public int hashCode() {
        int result = (int) (restaurantId ^ (restaurantId >>> 32));
        result = 31 * result + (typeOfDelivery != null ? typeOfDelivery.hashCode() : 0);
        result = 31 * result + (orderPrice != null ? orderPrice.hashCode() : 0);
        return result;
    }
}
