package ru.liga.service;

import ru.liga.domain.enitity.customerService.customer.CustomerAddress;

import java.util.List;

public interface CustomerAddressService {

    List<CustomerAddress> getAddressesByCustomerId(long customerId);


    CustomerAddress deleteCustomerAddressById(long addressId);
}
