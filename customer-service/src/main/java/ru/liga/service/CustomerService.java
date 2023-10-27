package ru.liga.service;


import ru.liga.domain.enitity.customerService.customer.Customer;

public interface CustomerService {

    Customer getCustomerById(long id);

    Customer updateCustomerEmailById(long id, String email);

    Customer deleteCustomerById(long id);

}
