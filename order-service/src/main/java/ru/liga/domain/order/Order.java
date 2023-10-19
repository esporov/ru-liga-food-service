package ru.liga.domain.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import ru.liga.domain.courier.Courier;
import ru.liga.domain.customer.Customer;
import ru.liga.domain.item.Item;
import ru.liga.domain.restaurant.Restaurant;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
