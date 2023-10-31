package ru.liga.web.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    @NotNull
    private String phoneNumber;

    @Email
    @NotNull
    private String customerEmail;

    @Override
    public String toString() {
        return "CustomerDto{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerDto that = (CustomerDto) o;

        if (!Objects.equals(phoneNumber, that.phoneNumber)) return false;
        return Objects.equals(customerEmail, that.customerEmail);
    }

    @Override
    public int hashCode() {
        int result = phoneNumber != null ? phoneNumber.hashCode() : 0;
        result = 31 * result + (customerEmail != null ? customerEmail.hashCode() : 0);
        return result;
    }
}
