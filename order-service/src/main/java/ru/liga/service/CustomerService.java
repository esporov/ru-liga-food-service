package ru.liga.service;


import ru.liga.domain.enitity.orderService.customer.Customer;
import ru.liga.domain.enitity.orderService.customer.CustomerAddress;

import java.util.List;

public interface CustomerService {

    Customer getCustomerById(long id);


    Customer updateCustomerEmailById(long id, String email);

    Customer deleteCustomerById(long id);

    CustomerAddress getCustomerAddressByAddressId(long addressId);
    List<CustomerAddress> getAllAddressByCustomerId(long customerId);

    CustomerAddress deleteCustomerAddressByAddressId(long addressId);

}
