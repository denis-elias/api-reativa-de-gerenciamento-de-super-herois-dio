package com.digitalinnovationone.heroesapi.config;


import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

import static com.digitalinnovationone.heroesapi.constants.HeroesConstant.ENDPOINT_DYNAMO;
import static com.digitalinnovationone.heroesapi.constants.HeroesConstant.REGION_DYNAMO;

public class HeroesData {

    public static void main(String[] args) {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Heroes_Table");

        Item hero1 = new Item()
                .withPrimaryKey("id", 1)
                .withString("name", "Superman")
                .withString("universe", "DC Comics")
                .withNumber("films", 3);

        Item hero2 = new Item()
                .withPrimaryKey("id", 1)
                .withString("name", "Hawkeye")
                .withString("universe", "Marvel")
                .withNumber("films", 3);

        Item hero3 = new Item()
                .withPrimaryKey("id", 1)
                .withString("name", "Capitão Marvel")
                .withString("universe", "Marvel")
                .withNumber("films", 3);

        PutItemOutcome outcome1 = table.putItem(hero1);
        PutItemOutcome outcome2 = table.putItem(hero2);
        PutItemOutcome outcome3 = table.putItem(hero3);
    }

}
