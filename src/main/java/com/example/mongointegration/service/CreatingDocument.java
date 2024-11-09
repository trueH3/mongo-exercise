package com.example.mongointegration.service;

import org.bson.Document;
import org.bson.types.Decimal128;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class CreatingDocument {

    public Document tcreateDocument () {
        final var doc = new Document("_id", new ObjectId())
                .append("customKey", new Decimal128(1L))
                .append("embeddedDocument", new Document()
                                .append("innerProperty", "someVal")
                                .append("anotherInnerVal", "some2")
                        );
        return doc;
    }
}
