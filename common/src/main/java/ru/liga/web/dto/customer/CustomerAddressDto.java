package ru.liga.web.dto.customer;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
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

}
