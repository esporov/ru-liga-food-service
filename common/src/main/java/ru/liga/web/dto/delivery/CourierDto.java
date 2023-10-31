package ru.liga.web.dto.delivery;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.liga.domain.enitity.deliveryService.courier.CourierStatus;

import javax.validation.constraints.NotNull;
import java.util.Objects;


@Schema(description = "Item DTO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourierDto {

    @NotNull(message = "Номер телефона  должен быть заполнен.")
    private String phoneNumber;

    @NotNull(message = "Необходимо указать статус курьера.")
    private CourierStatus courierStatus;

    @Override
    public String toString() {
        return "CourierDto{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", courierStatus=" + courierStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourierDto that = (CourierDto) o;

        if (!Objects.equals(phoneNumber, that.phoneNumber)) return false;
        return courierStatus == that.courierStatus;
    }

    @Override
    public int hashCode() {
        int result = phoneNumber != null ? phoneNumber.hashCode() : 0;
        result = 31 * result + (courierStatus != null ? courierStatus.hashCode() : 0);
        return result;
    }
}
