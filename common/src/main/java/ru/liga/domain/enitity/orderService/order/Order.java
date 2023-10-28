package ru.liga.domain.enitity.orderService.order;

import lombok.Builder;
import ru.liga.domain.enitity.deliveryService.courier.Courier;
import ru.liga.domain.enitity.orderService.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
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
}
