package web.dto.customer;

import com.fasterxml.jackson.annotation.JsonFormat;
import domain.enitity.customerService.customer.Customer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

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
