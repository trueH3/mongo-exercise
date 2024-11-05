package com.example.mongointegration.service;

import com.example.mongointegration.document.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnotherWayOfFetchingCustomer {

    private final MongoTemplate mongoTemplate;

    public String getCustomerByName(final String firstName) {

        final var query = new Query();
        query.addCriteria(Criteria.where("firstName").is(firstName));
        return mongoTemplate.findOne(query, String.class, "Customers");
    }
}
