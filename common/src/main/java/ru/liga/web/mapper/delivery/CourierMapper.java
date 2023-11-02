package ru.liga.web.mapper.delivery;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.liga.domain.enitity.deliveryService.courier.Courier;
import ru.liga.web.dto.delivery.CourierDto;
import ru.liga.web.mapper.Mappable;

@Component
@Mapper(componentModel = "spring")
public interface CourierMapper extends Mappable<Courier, CourierDto> {
}
