package ru.liga.domain.restaurant;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;
import ru.liga.domain.item.Item;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private long restaurantId;

    @Column(name = "restaurant_name")
    private String restaurantName;

    @OneToMany
    @JoinTable(name = "restaurants_restaurant_address",
            joinColumns = @JoinColumn(
                    name = "restaurant_id",
                    referencedColumnName = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "address_id",
                    referencedColumnName = "address_id"))
    private List<RestaurantAddress> restaurantAddresses;

    @OneToMany
    @JoinTable(name = "restaurants_menu_items",
            joinColumns = @JoinColumn(
                    name = "restaurant_id",
                    referencedColumnName = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "item_id",
                    referencedColumnName = "item_id"))
    private List<Item> restaurantMenu;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Restaurant that = (Restaurant) o;

        if (restaurantId != that.restaurantId) return false;
        if (restaurantName != null ? !restaurantName.equals(that.restaurantName) : that.restaurantName != null)
            return false;
        if (restaurantAddresses != null ? !restaurantAddresses.equals(that.restaurantAddresses) : that.restaurantAddresses != null)
            return false;
        return restaurantMenu != null ? restaurantMenu.equals(that.restaurantMenu) : that.restaurantMenu == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (restaurantId ^ (restaurantId >>> 32));
        result = 31 * result + (restaurantName != null ? restaurantName.hashCode() : 0);
        result = 31 * result + (restaurantAddresses != null ? restaurantAddresses.hashCode() : 0);
        result = 31 * result + (restaurantMenu != null ? restaurantMenu.hashCode() : 0);
        return result;
    }
}
