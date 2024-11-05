package com.example.mongointegration.migration;

import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import org.springframework.data.mongodb.core.MongoTemplate;

@ChangeUnit(order = "003", id = "add-customer-nested-document", author = "Szym")
public class Mig3 {

    @Execution
    public void addCustomer (final MongoTemplate mongoTemplate) {
        //dont like this idea because Customer can change in future and this script may not be able to compile
//        final var customer = new Customer();
//        customer.setId("6723762b3d46dad12ac901bd");
//        customer.setFirstName("szym");
//        customer.setLastName("NONAME");
//        mongoTemplate.insert(customer);

        final var customer = """
                {
                  "firstName": "szym",
                  "lastName": "whatever",
                  "address": {
                    "street": "some street",
                    "houseNumber": 31
                  }                  
                }
                """;
        mongoTemplate.insert(customer, "Customers");
    }


    @RollbackExecution
    public void rollbackAddCustomers (final MongoTemplate mongoTemplate) {
    }
}
