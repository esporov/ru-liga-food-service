package ru.liga.domain.enitity.orderService.order;

import lombok.*;
import ru.liga.domain.enitity.deliveryService.courier.Courier;
import ru.liga.domain.enitity.orderService.customer.Customer;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Builder
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "restaurant_id")
    private long restaurantId;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "type_of_delivery")
    private TypeOfDelivery typeOfDelivery;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "order_price")
    private BigDecimal orderPrice;

    @ManyToOne
    @JoinColumn(name = "courier_id")
    private Courier courier;

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customer=" + customer +
                ", restaurantId=" + restaurantId +
                ", orderStatus=" + orderStatus +
                ", typeOfDelivery=" + typeOfDelivery +
                ", createDate=" + createDate +
                ", orderPrice=" + orderPrice +
                ", courier=" + courier +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderId != order.orderId) return false;
        if (restaurantId != order.restaurantId) return false;
        if (!Objects.equals(customer, order.customer)) return false;
        if (orderStatus != order.orderStatus) return false;
        if (typeOfDelivery != order.typeOfDelivery) return false;
        if (!Objects.equals(createDate, order.createDate)) return false;
        if (!Objects.equals(orderPrice, order.orderPrice)) return false;
        return Objects.equals(courier, order.courier);
    }

    @Override
    public int hashCode() {
        int result = (int) (orderId ^ (orderId >>> 32));
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (int) (restaurantId ^ (restaurantId >>> 32));
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        result = 31 * result + (typeOfDelivery != null ? typeOfDelivery.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (orderPrice != null ? orderPrice.hashCode() : 0);
        result = 31 * result + (courier != null ? courier.hashCode() : 0);
        return result;
    }
}
