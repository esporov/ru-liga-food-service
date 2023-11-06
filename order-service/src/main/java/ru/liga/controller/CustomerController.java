package ru.liga.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.liga.service.CustomerService;
import ru.liga.web.dto.customer.CustomerDto;
import ru.liga.web.mapper.customer.CustomerMapper;


@RestController
@RequestMapping("/order-service/customer-api")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;


    @GetMapping("/v1.0/customer/id/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") long id) {
        var customer = customerService.getCustomerById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(customerMapper.toDto(customer));
    }

    @DeleteMapping("/v1.0/customer/id/{id}/deleteCustomer")
    public ResponseEntity<CustomerDto> deleteCustomerById(@PathVariable("id") long id) {
        var customer = customerService.deleteCustomerById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(customerMapper.toDto(customer));
    }

}
