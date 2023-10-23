package service.impl;

import domain.enitity.customerService.customer.Customer;
import domain.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CustomerRepository;
import service.CustomerService;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer getCustomerById(long id) {
        try {
            return customerRepository.getCustomerById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Клиента с id = " + id + " не существует."));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public Customer updateCustomerEmailById(long id, String email) {
        getCustomerById(id);
        customerRepository.updateCustomerEmailById(id, email);
        return getCustomerById(id);
    }

    @Transactional
    @Override
    public Customer deleteCustomerById(long id) {
        var customer = getCustomerById(id);
        customerRepository.deleteById(id);
        return customer;
    }
}
