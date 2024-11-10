package com.example.mongointegration;

import com.example.mongointegration.document.Customer;
import com.example.mongointegration.repository.CustomerRepository;
import com.example.mongointegration.service.AggregationPipelineService;
import com.example.mongointegration.service.AnotherWayOfFetchingCustomer;
import com.example.mongointegration.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExampleController {

    private final CustomerRepository customerRepository;
    private final AnotherWayOfFetchingCustomer anotherWayOfFetchingCustomer;
    private final TransactionService transactionService;
    private final AggregationPipelineService aggregationPipelineService;

    @GetMapping("/customer/{name}")
    public Customer getCustomerByName(@PathVariable String name) {
        return customerRepository.findByFirstName(name);
    }

    @GetMapping("/customer2/{name}")
    public String getCustomerByName2(@PathVariable String name) {
        return anotherWayOfFetchingCustomer.getCustomerByName(name);
    }

    @GetMapping("/increment")
    public void increment() {
        transactionService.updateTwiceWithTransaction();
    }

    @GetMapping("/aggregate")
    public List<Document> aggregate() {
        return aggregationPipelineService.getUserAmountSum("szym");
    }
}
