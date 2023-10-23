package web.dto.delivery;

import domain.enitity.deliveryService.courier.CourierStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


import javax.validation.constraints.NotNull;


@Schema(description = "Item DTO")
@Data
public class CourierDto {

    @NotNull(message = "Номер телефона  должен быть заполнен.")
    private String phoneNumber;

    @NotNull(message = "Необходимо указать статус курьера.")
    private CourierStatus courierStatus;

}
