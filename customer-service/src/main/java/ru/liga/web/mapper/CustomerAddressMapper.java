package ru.liga.web.mapper;

import ru.liga.domain.enitity.customerService.customer.CustomerAddress;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.liga.web.dto.customer.CustomerAddressDto;
import ru.liga.web.mapper.Mappable;

@Mapper(componentModel = "spring")
@Component
public interface CustomerAddressMapper extends Mappable<CustomerAddress, CustomerAddressDto> {
}
