package ru.liga.web.mapper;

import ru.liga.domain.enitity.deliveryService.courier.Courier;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.liga.web.dto.delivery.CourierDto;

@Component
@Mapper(componentModel = "spring")
public interface CourierMapper extends Mappable<Courier, CourierDto> {
}
