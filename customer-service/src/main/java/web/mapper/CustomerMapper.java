package web.mapper;

import domain.enitity.customerService.customer.Customer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import web.dto.customer.CustomerDto;

@Mapper(componentModel = "spring")
@Component
public interface CustomerMapper extends Mappable<Customer, CustomerDto> {
}
