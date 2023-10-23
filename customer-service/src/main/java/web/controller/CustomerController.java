package web.controller;

import domain.enitity.customerService.customer.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.CustomerService;
import web.dto.customer.CustomerDto;
import web.mapper.CustomerAddressMapper;
import web.mapper.CustomerMapper;

@RestController
@RequestMapping("/customer-api")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;
    private final CustomerAddressMapper customerAddressMapper;


    @GetMapping("/v1.0/customer")
    public ResponseEntity<CustomerDto> getCustomerById(@RequestParam("id") long id) {
        var customer = customerService.getCustomerById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(customerMapper.toDto(customer));
    }

    @DeleteMapping("/v1.0/deleteCustomer")
    public ResponseEntity<CustomerDto> deleteCustomerById(@RequestParam("id") long id) {
        var customer = customerService.deleteCustomerById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(customerMapper.toDto(customer));
    }

}
