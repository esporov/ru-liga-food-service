package ru.liga.domain.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.liga.domain.restaurant.Restaurant;

import javax.persistence.*;

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
    private int itemPrice;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "item_status")
    private ItemStatus itemStatus;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "restaurants_menu_items",
            inverseJoinColumns = @JoinColumn(
                    name = "restaurant_id",
                    referencedColumnName = "restaurant_id"),
            joinColumns = @JoinColumn(
                    name = "item_id",
                    referencedColumnName = "item_id"))
    private Restaurant restaurant;
}
