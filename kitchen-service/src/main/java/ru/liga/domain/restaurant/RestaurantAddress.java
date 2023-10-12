package ru.liga.domain.restaurant;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RestaurantAddress that = (RestaurantAddress) o;

        if (addressId != that.addressId) return false;
        if (streetName != null ? !streetName.equals(that.streetName) : that.streetName != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (dateOfAdd != null ? !dateOfAdd.equals(that.dateOfAdd) : that.dateOfAdd != null) return false;
        return restaurantStatus == that.restaurantStatus;
    }

    @Override
    public int hashCode() {
        int result = (int) (addressId ^ (addressId >>> 32));
        result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (dateOfAdd != null ? dateOfAdd.hashCode() : 0);
        result = 31 * result + (restaurantStatus != null ? restaurantStatus.hashCode() : 0);
        return result;
    }
}
