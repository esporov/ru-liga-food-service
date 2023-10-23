package ru.liga.web.mapper;

import domain.enitity.deliveryService.courier.Courier;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import web.dto.delivery.CourierDto;
import web.mapper.Mappable;

@Component
@Mapper(componentModel = "spring")
public interface CourierMapper extends Mappable<Courier, CourierDto> {
}
