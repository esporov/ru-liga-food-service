package ru.liga.domain.enitity.kitchenService.item;

import lombok.*;
import ru.liga.domain.enitity.kitchenService.restaurant.Restaurant;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "menu_items")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
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

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemImage='" + itemImage + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", itemStatus=" + itemStatus +
                ", restaurant=" + restaurant +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (itemId != item.itemId) return false;
        if (!Objects.equals(itemName, item.itemName)) return false;
        if (!Objects.equals(itemPrice, item.itemPrice)) return false;
        if (!Objects.equals(itemImage, item.itemImage)) return false;
        if (!Objects.equals(itemDescription, item.itemDescription))
            return false;
        if (itemStatus != item.itemStatus) return false;
        return Objects.equals(restaurant, item.restaurant);
    }

    @Override
    public int hashCode() {
        int result = (int) (itemId ^ (itemId >>> 32));
        result = 31 * result + (itemName != null ? itemName.hashCode() : 0);
        result = 31 * result + (itemPrice != null ? itemPrice.hashCode() : 0);
        result = 31 * result + (itemImage != null ? itemImage.hashCode() : 0);
        result = 31 * result + (itemDescription != null ? itemDescription.hashCode() : 0);
        result = 31 * result + (itemStatus != null ? itemStatus.hashCode() : 0);
        result = 31 * result + (restaurant != null ? restaurant.hashCode() : 0);
        return result;
    }
}
