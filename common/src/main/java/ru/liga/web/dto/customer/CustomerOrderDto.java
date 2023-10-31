package ru.liga.web.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.liga.domain.enitity.orderService.order.OrderStatus;
import ru.liga.domain.enitity.orderService.order.TypeOfDelivery;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOrderDto {

    @NotNull
    private long restaurantId;
    @NotNull
    private OrderStatus orderStatus;
    @NotNull
    private TypeOfDelivery typeOfDelivery;
    @NotNull
    private BigDecimal orderPrice;

    @Override
    public String toString() {
        return "CustomerOrderDto{" +
                "restaurantId=" + restaurantId +
                ", orderStatus=" + orderStatus +
                ", typeOfDelivery=" + typeOfDelivery +
                ", orderPrice=" + orderPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerOrderDto that = (CustomerOrderDto) o;

        if (restaurantId != that.restaurantId) return false;
        if (orderStatus != that.orderStatus) return false;
        if (typeOfDelivery != that.typeOfDelivery) return false;
        return Objects.equals(orderPrice, that.orderPrice);
    }

    @Override
    public int hashCode() {
        int result = (int) (restaurantId ^ (restaurantId >>> 32));
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        result = 31 * result + (typeOfDelivery != null ? typeOfDelivery.hashCode() : 0);
        result = 31 * result + (orderPrice != null ? orderPrice.hashCode() : 0);
        return result;
    }
}
