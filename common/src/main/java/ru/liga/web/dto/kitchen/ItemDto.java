package ru.liga.web.dto.kitchen;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import ru.liga.domain.enitity.kitchenService.item.ItemStatus;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Objects;

@Schema(description = "Item DTO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {

    @NotNull(message = "Название позиции должно быть заполнено.")
    @Length(max = 255, message = "Название должно быть не более 255 символов.")
    private String itemName;

    @NotNull(message = "Цена должна быть указана.")
    @Positive(message = "Цена должна быть больше нуля.")
    private int itemPrice;

    @NotNull(message = "Необходимо указать находится ли позиция в стоп-листе.")
    private ItemStatus itemStatus;

    @Override
    public String toString() {
        return "ItemDto{" +
                "itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemStatus=" + itemStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemDto itemDto = (ItemDto) o;

        if (itemPrice != itemDto.itemPrice) return false;
        if (!Objects.equals(itemName, itemDto.itemName)) return false;
        return itemStatus == itemDto.itemStatus;
    }

    @Override
    public int hashCode() {
        int result = itemName != null ? itemName.hashCode() : 0;
        result = 31 * result + itemPrice;
        result = 31 * result + (itemStatus != null ? itemStatus.hashCode() : 0);
        return result;
    }
}
