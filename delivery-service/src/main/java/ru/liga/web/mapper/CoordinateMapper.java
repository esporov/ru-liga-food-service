package ru.liga.web.mapper;

import ru.liga.domain.enitity.deliveryService.coordinate.Coordinate;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.liga.web.dto.delivery.CoordinateDto;


@Component
@Mapper(componentModel = "spring")
public interface CoordinateMapper extends Mappable<Coordinate, CoordinateDto> {
}
