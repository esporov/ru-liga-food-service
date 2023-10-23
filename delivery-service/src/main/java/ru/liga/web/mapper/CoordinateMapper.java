package ru.liga.web.mapper;

import domain.enitity.deliveryService.coordinate.Coordinate;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import web.dto.delivery.CoordinateDto;
import web.mapper.Mappable;


@Component
@Mapper(componentModel = "spring")
public interface CoordinateMapper extends Mappable<Coordinate, CoordinateDto> {
}
