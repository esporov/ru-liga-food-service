package ru.liga.domain.enitity.kitchenService.item;

import ru.liga.domain.enitity.kitchenService.restaurant.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "menu_items")
public class Item {

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "restaurant_id",referencedColumnName = "restaurant_id")
    private Restaurant restaurant;

}
