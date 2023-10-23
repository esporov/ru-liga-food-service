package web.dto.customer;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class CustomerDto {

    @NotNull
    private String phoneNumber;

    @Email
    @NotNull
    private String customerEmail;
}
