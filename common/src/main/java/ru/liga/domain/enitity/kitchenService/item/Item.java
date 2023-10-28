package ru.liga.domain.enitity.kitchenService.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.liga.domain.enitity.kitchenService.restaurant.Restaurant;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "menu_items")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private long itemId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_price")
    private BigDecimal itemPrice;

    @Column(name = "item_image")
    private String itemImage;

    @Column(name = "item_description")
    private String itemDescription;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "item_status")
    private ItemStatus itemStatus;

    @ManyToOne
    @JoinColumn (name = "restaurant_id",referencedColumnName = "restaurant_id")
    private Restaurant restaurant;

}
