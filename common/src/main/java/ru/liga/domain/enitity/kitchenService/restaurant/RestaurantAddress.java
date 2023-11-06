package ru.liga.domain.enitity.kitchenService.restaurant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "restaurant_address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public  class RestaurantAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private long addressId;

    @Column(name = "street_name")
    private String streetName;

    private String city;

    @Column(name = "date_of_add")
    private Date dateOfAdd;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "work_status")
    private RestaurantStatus restaurantStatus;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn (name = "restaurant_id",referencedColumnName = "restaurant_id")
    private Restaurant restaurant;

    @Override
    public String toString() {
        return "RestaurantAddress{" +
                "addressId=" + addressId +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", dateOfAdd=" + dateOfAdd +
                ", restaurantStatus=" + restaurantStatus +
                ", restaurant=" + restaurant +
                '}';
    }

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
