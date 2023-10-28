package ru.liga.web.mapper.customer;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.liga.domain.enitity.orderService.customer.CustomerAddress;
import ru.liga.web.dto.customer.CustomerAddressDto;
import ru.liga.web.mapper.Mappable;

@Mapper(componentModel = "spring")
@Component
public interface CustomerAddressMapper extends Mappable<CustomerAddress, CustomerAddressDto> {
}
