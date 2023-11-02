package ru.liga.web.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddressDto {

    @NotNull
    private String city;
    @NotNull
    private String street;

    @NotNull
    private String houseNumber;

    @Null
    private String houseSection;

    @Null
    private String houseFloor;

    @Null
    private String apartmentNumber;

    @Override
    public String toString() {
        return "CustomerAddressDto{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", houseSection='" + houseSection + '\'' +
                ", houseFloor='" + houseFloor + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerAddressDto that = (CustomerAddressDto) o;

        if (!Objects.equals(city, that.city)) return false;
        if (!Objects.equals(street, that.street)) return false;
        if (!Objects.equals(houseNumber, that.houseNumber)) return false;
        if (!Objects.equals(houseSection, that.houseSection)) return false;
        if (!Objects.equals(houseFloor, that.houseFloor)) return false;
        return Objects.equals(apartmentNumber, that.apartmentNumber);
    }

    @Override
    public int hashCode() {
        int result = city != null ? city.hashCode() : 0;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (houseNumber != null ? houseNumber.hashCode() : 0);
        result = 31 * result + (houseSection != null ? houseSection.hashCode() : 0);
        result = 31 * result + (houseFloor != null ? houseFloor.hashCode() : 0);
        result = 31 * result + (apartmentNumber != null ? apartmentNumber.hashCode() : 0);
        return result;
    }
}
