package com.example.mongointegration.document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customers") // if i want to avoid explicit mapping i need to name collecion "customer" from lower case
@Getter
@Setter
@ToString
public class Customer {

    @Id
    private String id;

    private String firstName;
    private String lastName;
}
