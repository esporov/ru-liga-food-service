package ru.liga.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import ru.liga.domain.courier.Courier;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Data
@Schema(description = "Restaurant DTO")
public class CoordinateDto {

    @NotNull
    private float latitude;

    @NotNull
    private float longitude;

}