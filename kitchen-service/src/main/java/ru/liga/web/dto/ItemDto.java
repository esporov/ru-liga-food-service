package ru.liga.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import ru.liga.domain.item.ItemStatus;
import ru.liga.domain.restaurant.Restaurant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Schema(description = "Item DTO")
@Data
public class ItemDto {

    @NotNull(message = "Название позиции должно быть заполнено.")
    @Length(max = 255, message = "Название должно быть не более 255 символов.")
    private String itemName;

    @NotNull(message = "Цена должна быть указана.")
    @Positive(message = "Цена должна быть больше нуля.")
    private int itemPrice;

    @NotNull(message = "Необходимо указать находится ли позиция в стоп-листе.")
    private ItemStatus itemStatus;
}
