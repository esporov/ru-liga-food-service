package ru.liga.domain.enitity.orderService.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "customer_addressees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private long addressId;

    private String city;

    private String street;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "house_section")
    private String houseSection;
    @Column(name = "house_floor")
    private String houseFloor;
    @Column(name = "apartment_number")
    private String apartmentNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "customer_id",referencedColumnName = "customer_id")
    private Customer customer;

    @Override
    public String toString() {
        return "CustomerAddress{" +
                "addressId=" + addressId +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", houseSection='" + houseSection + '\'' +
                ", houseFloor='" + houseFloor + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", customer=" + customer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerAddress that = (CustomerAddress) o;

        if (addressId != that.addressId) return false;
        if (!Objects.equals(city, that.city)) return false;
        if (!Objects.equals(street, that.street)) return false;
        if (!Objects.equals(houseNumber, that.houseNumber)) return false;
        if (!Objects.equals(houseSection, that.houseSection)) return false;
        if (!Objects.equals(houseFloor, that.houseFloor)) return false;
        if (!Objects.equals(apartmentNumber, that.apartmentNumber))
            return false;
        return Objects.equals(customer, that.customer);
    }

    @Override
    public int hashCode() {
        int result = (int) (addressId ^ (addressId >>> 32));
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (houseNumber != null ? houseNumber.hashCode() : 0);
        result = 31 * result + (houseSection != null ? houseSection.hashCode() : 0);
        result = 31 * result + (houseFloor != null ? houseFloor.hashCode() : 0);
        result = 31 * result + (apartmentNumber != null ? apartmentNumber.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        return result;
    }
}
