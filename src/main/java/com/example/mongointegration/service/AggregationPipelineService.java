package com.example.mongointegration.service;

import com.mongodb.client.model.Filters;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AggregationPipelineService {

    private final MongoTemplate mongoTemplate;

    public List<Document> getUserAmountSum(String userName) {
        // Define the $match stage to filter by "user"
        final var matchUser = Aggregation.match(Criteria.where("user").is(userName));

        // Define the $group stage to group by "user" and sum the "amount" field
        final var groupByUserAndSumAmount = Aggregation.group("user")
                .sum("amount").as("sumAmount")
                .avg("amount").as("avgAmount");

        // Define the $project stage to exclude the "_id" field
        final var projectExcludeId = Aggregation.project("sumAmount", "avgAmount").andExclude("_id");

        // Build the aggregation pipeline with $match, $group, and $project stages
        final var aggregation = Aggregation.newAggregation(matchUser, groupByUserAndSumAmount, projectExcludeId);

        // Execute the aggregation and return the results as a list of Document objects
        final var results = mongoTemplate.aggregate(aggregation, "Transactions", Document.class);

        return results.getMappedResults();
    }
}
