package ru.liga.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.liga.web.mapper.CustomerMapper;
import ru.liga.service.CustomerService;
import ru.liga.web.dto.customer.CustomerDto;
import ru.liga.web.mapper.CustomerAddressMapper;

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
