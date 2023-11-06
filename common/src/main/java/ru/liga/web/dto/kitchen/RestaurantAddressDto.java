package ru.liga.web.dto.kitchen;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import ru.liga.domain.enitity.kitchenService.restaurant.RestaurantStatus;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Schema(title = "Address", description = "Адрес ресторана")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantAddressDto {

    @Schema(description = "Улица", example = "ул. Бетанкура, д. 1")
    @NotNull(message = "Название улицы должно быть заполнено.")
    @Length(max = 255, message = "Название должно быть не более 255 символов.")
    private String streetName;

    @Schema(description = "Город", example = "Нижний Новгород")
    @NotNull(message = "Название города должно быть заполнено.")
    @Length(max = 255, message = "Название должно быть не более 255 символов.")
    private String city;

    @Schema(description = "Рабочий статус ресторана", example = "ACTIVE")
    @NotNull(message = "Необходимо указать статус ресторана по данному адресу.")
    private RestaurantStatus restaurantStatus;

    @Hidden
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfAdd;

    @Override
    public String toString() {
        return "RestaurantAddressDto{" +
                "streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", restaurantStatus=" + restaurantStatus +
                ", dateOfAdd=" + dateOfAdd +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RestaurantAddressDto that = (RestaurantAddressDto) o;

        if (!Objects.equals(streetName, that.streetName)) return false;
        if (!Objects.equals(city, that.city)) return false;
        if (restaurantStatus != that.restaurantStatus) return false;
        return Objects.equals(dateOfAdd, that.dateOfAdd);
    }

    @Override
    public int hashCode() {
        int result = streetName != null ? streetName.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (restaurantStatus != null ? restaurantStatus.hashCode() : 0);
        result = 31 * result + (dateOfAdd != null ? dateOfAdd.hashCode() : 0);
        return result;
    }
}
