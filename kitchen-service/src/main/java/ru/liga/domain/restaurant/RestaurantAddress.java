package ru.liga.domain.restaurant;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "restaurant_address")
public  class RestaurantAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private long addressId;

    @Column(name = "street_name")
    private String streetName;

    private String city;

    @Column(name = "date_of_add")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfAdd;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "restaurant_status")
    private RestaurantStatus restaurantStatus;

    @ManyToOne
    @JoinTable(name = "restaurants_restaurant_address",
            inverseJoinColumns = @JoinColumn(
                    name = "restaurant_id",
                    referencedColumnName = "restaurant_id"),
            joinColumns = @JoinColumn(
                    name = "address_id",
                    referencedColumnName = "address_id"))
    private Restaurant restaurant;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RestaurantAddress that = (RestaurantAddress) o;

        if (addressId != that.addressId) return false;
        if (!Objects.equals(streetName, that.streetName)) return false;
        if (!Objects.equals(city, that.city)) return false;
        if (!Objects.equals(dateOfAdd, that.dateOfAdd)) return false;
        if (restaurantStatus != that.restaurantStatus) return false;
        return Objects.equals(restaurant, that.restaurant);
    }

    @Override
    public int hashCode() {
        int result = (int) (addressId ^ (addressId >>> 32));
        result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (dateOfAdd != null ? dateOfAdd.hashCode() : 0);
        result = 31 * result + (restaurantStatus != null ? restaurantStatus.hashCode() : 0);
        result = 31 * result + (restaurant != null ? restaurant.hashCode() : 0);
        return result;
    }
}
