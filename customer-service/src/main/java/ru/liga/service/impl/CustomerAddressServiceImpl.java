package ru.liga.service.impl;

import ru.liga.domain.enitity.customerService.customer.CustomerAddress;
import ru.liga.domain.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.repository.CustomerAddressRepository;
import ru.liga.service.CustomerAddressService;

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
