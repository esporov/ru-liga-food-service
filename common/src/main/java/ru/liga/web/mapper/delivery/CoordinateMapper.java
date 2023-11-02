package ru.liga.web.mapper.delivery;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.liga.domain.enitity.deliveryService.coordinate.Coordinate;
import ru.liga.web.dto.delivery.CoordinateDto;
import ru.liga.web.mapper.Mappable;


@Component
@Mapper(componentModel = "spring")
public interface CoordinateMapper extends Mappable<Coordinate, CoordinateDto> {
}
