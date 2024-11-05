package com.example.mongointegration.repository;

import com.example.mongointegration.document.Customer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, ObjectId> {

    Customer findByFirstName(final String firstName);
}
