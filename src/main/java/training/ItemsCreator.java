package training;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

public class ItemsCreator {
    public Boolean putItem() {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("IGHItems");

        Item item = new Item()
                .withPrimaryKey("ghid", 1)
                .withString("Title", "cycle")
                .withNumber("shelflife", 12365)
                .withBoolean("discontinued", false);

        table.putItem(item);

        PutItemOutcome outcome = table.putItem(item);

        if(outcome !=null)

        { System.out.println("Items inserted");
        return true;

    }
        else{
            System.out.println("Items not inserted");
            return false;
        }
}}