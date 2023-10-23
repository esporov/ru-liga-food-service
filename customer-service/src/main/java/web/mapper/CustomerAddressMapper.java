package web.mapper;

import domain.enitity.customerService.customer.CustomerAddress;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import web.dto.customer.CustomerAddressDto;

@Mapper(componentModel = "spring")
@Component
public interface CustomerAddressMapper extends Mappable<CustomerAddress, CustomerAddressDto>{
}
