package ru.liga.web.mapper;

import ru.liga.domain.enitity.customerService.customer.Customer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.liga.web.dto.customer.CustomerDto;
import ru.liga.web.mapper.Mappable;

@Mapper(componentModel = "spring")
@Component
public interface CustomerMapper extends Mappable<Customer, CustomerDto> {
}
