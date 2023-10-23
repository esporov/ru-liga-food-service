package service.impl;

import domain.enitity.customerService.customer.CustomerAddress;
import domain.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CustomerAddressRepository;
import service.CustomerAddressService;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomerAddressServiceImpl implements CustomerAddressService {

    private final CustomerAddressRepository customerAddressRepository;
    @Override
    public List<CustomerAddress> getAddressesByCustomerId(long customerId) {
        return customerAddressRepository.getAddressesByCustomerId(customerId);
    }

    @Override
    public CustomerAddress deleteCustomerAddressById(long addressId) {
        try {
            var address = customerAddressRepository.findById(addressId)
                    .orElseThrow(()-> new ResourceNotFoundException("Указанного адреса не существует."));
            customerAddressRepository.deleteById(addressId);
            return address;
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
