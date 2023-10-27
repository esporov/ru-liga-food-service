package ru.liga.web.dto.delivery;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Schema(description = "Restaurant DTO")
public class CoordinateDto {

    @NotNull
    private float latitude;

    @NotNull
    private float longitude;

}