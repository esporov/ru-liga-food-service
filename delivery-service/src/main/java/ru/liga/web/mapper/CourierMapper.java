package ru.liga.web.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.liga.domain.courier.Courier;
import ru.liga.web.dto.CourierDto;
@Component
@Mapper(componentModel = "spring")
public interface CourierMapper extends Mappable<Courier, CourierDto>{
}
