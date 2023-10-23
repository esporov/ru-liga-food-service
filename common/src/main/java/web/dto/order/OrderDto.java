package web.dto.order;

import domain.enitity.customerService.customer.Customer;
import domain.enitity.deliveryService.courier.Courier;
import domain.enitity.orderService.order.OrderStatus;
import domain.enitity.orderService.order.TypeOfDelivery;
import lombok.Data;

import javax.persistence.*;
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
