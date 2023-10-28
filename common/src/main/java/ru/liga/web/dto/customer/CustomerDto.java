package ru.liga.web.dto.customer;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class CustomerDto {

    @NotNull
    private String phoneNumber;

    @Email
    @NotNull
    private String customerEmail;
}
