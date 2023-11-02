package ru.liga.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.domain.enitity.orderService.customer.Customer;
import ru.liga.domain.enitity.orderService.customer.CustomerAddress;
import ru.liga.domain.exception.CustomerNotFoundException;
import ru.liga.repository.CustomerAddressRepository;
import ru.liga.repository.CustomerRepository;
import ru.liga.service.CustomerService;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerAddressRepository customerAddressRepository;

    @Override
    public Customer getCustomerById(long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Клиента с id = " + id + " не существует."));
    }

    @Override
    public CustomerAddress getCustomerAddressByAddressId(long addressId) {
        return customerAddressRepository.findById(addressId)
                .orElseThrow(() -> new CustomerNotFoundException("Адрес по id = " + addressId + " отсутствует."));
    }

    @Override
    public List<CustomerAddress> getAllAddressByCustomerId(long customerId) {
        getCustomerById(customerId);
        List<CustomerAddress> addressList = customerAddressRepository.getAddressesByCustomerId(customerId);
        if (addressList.size() == 0) {
            throw new CustomerNotFoundException("Адреса у клиента по id = " + customerId + " отсутствуют.");
        }
        return addressList;
    }

    @Transactional
    @Override
    public Customer updateCustomerEmailById(long id, String email) {
        var customer = getCustomerById(id);
        customer.setCustomerEmail(email);
        customerRepository.updateCustomerEmailById(id, email);
        return customer;
    }

    @Transactional
    @Override
    public Customer deleteCustomerById(long id) {
        var customer = getCustomerById(id);
        customerRepository.deleteById(id);
        return customer;
    }

    @Transactional
    @Override
    public CustomerAddress deleteCustomerAddressByAddressId(long addressId) {
        var address = getCustomerAddressByAddressId(addressId);
        customerAddressRepository.deleteById(addressId);
        return address;
    }
}
