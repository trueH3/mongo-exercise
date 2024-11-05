package com.example.mongointegration.migration;

import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import org.springframework.data.mongodb.core.MongoTemplate;

@ChangeUnit(order = "001", id = "create-customers-collection", author = "Szym")
public class Mig1 {

    @Execution
    public void createCustomers (final MongoTemplate mongoTemplate) {
        mongoTemplate.createCollection("Customers");
    }


    @RollbackExecution
    public void rollbackCreateCustomers (final MongoTemplate mongoTemplate) {
        mongoTemplate.dropCollection("Customers");
    }
}
