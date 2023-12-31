package ru.liga.web.dto.kitchen;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.liga.domain.enitity.kitchenService.restaurant.RestaurantStatus;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
public class RestaurantAddressDto {

    @NotNull(message = "Название улицы должно быть заполнено.")
    @Length(max = 255, message = "Название должно быть не более 255 символов.")
    private String streetName;

    @NotNull(message = "Название города должно быть заполнено.")
    @Length(max = 255, message = "Название должно быть не более 255 символов.")
    private String city;

    @NotNull(message = "Необходимо указать статус ресторана по данному адресу.")
    private RestaurantStatus restaurantStatus;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfAdd;
}
