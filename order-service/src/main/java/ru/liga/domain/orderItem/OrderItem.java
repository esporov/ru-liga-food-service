package ru.liga.domain.orderItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.liga.domain.item.Item;
import ru.liga.domain.order.Order;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToOne
    private Item item;
}
