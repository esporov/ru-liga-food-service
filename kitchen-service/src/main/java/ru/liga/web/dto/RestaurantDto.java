package ru.liga.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Schema(description = "Restaurant DTO")
public class RestaurantDto {

    @Schema(description = "Restaurant name", example = "БургерКвин")
    @NotNull
    @Length(max = 255, message = "Название должно быть не более 255 символов.")
    private String restaurantName;
}