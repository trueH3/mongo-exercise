package com.example.mongointegration.service;

import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final MongoTemplate mongoTemplate;

    // transaction won't work if my mongodb is created as a standalone instance and in this kind of installation
    // transaction are not supported. What need to be done in order to enable transactions is to launch mongodb as
    // single node replica set
    //
    @Transactional
    public void updateTwiceWithTransaction() {
        final var query = new Query(Criteria.where("identifier").is("xyz"));
        final var update = new Update().inc("customKey", 1);

        mongoTemplate.updateFirst(query, update, "Customers");
        final var divisionByZero = 3/0;
        mongoTemplate.updateFirst(query, update, "Customers");
    }
}
