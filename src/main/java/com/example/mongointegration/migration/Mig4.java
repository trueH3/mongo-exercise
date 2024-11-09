package com.example.mongointegration.migration;

import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import org.bson.Document;
import org.bson.types.Decimal128;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;

import static com.mongodb.client.model.Filters.gte;

@ChangeUnit(order = "004", id = "add-customer-nested-document-document-type", author = "Szym")
public class Mig4 {

    @Execution
    public void addCustomer (final MongoTemplate mongoTemplate) {

        final var doc = new Document("_id", new ObjectId())
                .append("customKey", new Decimal128(1L))
                .append("identifier", "xyz")
                .append("embeddedDocument", new Document()
                        .append("innerProperty", "someVal")
                        .append("anotherInnerVal", "some2")
                );
        final var insertResult = mongoTemplate.insert(doc, "Customers");
    }


    @RollbackExecution
    public void rollbackAddCustomers (final MongoTemplate mongoTemplate) {
    }
}
