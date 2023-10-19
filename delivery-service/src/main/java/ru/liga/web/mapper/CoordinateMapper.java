package ru.liga.web.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.liga.domain.coordinate.Coordinate;
import ru.liga.web.dto.CoordinateDto;

@Component
@Mapper(componentModel = "spring")
public interface CoordinateMapper extends Mappable<Coordinate, CoordinateDto> {
}
