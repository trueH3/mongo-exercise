package com.example.mongointegration;

import com.example.mongointegration.document.Customer;
import com.example.mongointegration.repository.CustomerRepository;
import com.example.mongointegration.service.AnotherWayOfFetchingCustomer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ExampleController {

    private final CustomerRepository customerRepository;
    private final AnotherWayOfFetchingCustomer anotherWayOfFetchingCustomer;

    @GetMapping("/customer/{name}")
    public Customer getCustomerByName(@PathVariable String name) {
        return customerRepository.findByFirstName(name);
    }

    @GetMapping("/customer2/{name}")
    public String getCustomerByName2(@PathVariable String name) {
        return anotherWayOfFetchingCustomer.getCustomerByName(name);
    }
 }
