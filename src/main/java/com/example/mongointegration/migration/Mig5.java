package com.example.mongointegration.migration;

import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import org.bson.Document;
import org.bson.types.Decimal128;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@ChangeUnit(order = "005", id = "add-user-money-transactions", author = "Szym")
public class Mig5 {

    @Execution
    public void addCustomer (final MongoTemplate mongoTemplate) {

        final var doc = new Document("_id", new ObjectId())
                .append("user", "szym")
                .append("amount", new Decimal128(200))
                .append("randomField", "blabla");

        final var doc1 = new Document("_id", new ObjectId())
                .append("user", "szym")
                .append("amount", new Decimal128(100))
                .append("randomField", "dubidu");

        final var doc2 = new Document("_id", new ObjectId())
                .append("user", "marco")
                .append("amount", new Decimal128(50))
                .append("randomField", "elelele");

        final var insertResult = mongoTemplate.insert(List.of(doc, doc1, doc2), "Transactions");
    }


    @RollbackExecution
    public void rollbackAddCustomers (final MongoTemplate mongoTemplate) {
    }
}
