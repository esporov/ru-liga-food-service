package ru.liga.web.dto.kitchen;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Schema(title = "Restaurant", description = "Ресторан")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {

    @Schema(description = "Название ресторана", example = "БургерКвин")
    @NotNull
    @Length(max = 255, message = "Название должно быть не более 255 символов.")
    private String restaurantName;

    @Override
    public String toString() {
        return "RestaurantDto{" +
                "restaurantName='" + restaurantName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RestaurantDto that = (RestaurantDto) o;

        return Objects.equals(restaurantName, that.restaurantName);
    }

    @Override
    public int hashCode() {
        return restaurantName != null ? restaurantName.hashCode() : 0;
    }
}