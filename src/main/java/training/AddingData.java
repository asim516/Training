package training;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;


import java.util.Arrays;
import java.util.HashSet;

public class AddingData {

    AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();

    DynamoDBMapper mapper = new DynamoDBMapper(client);

    public  void save() {

        TableCatalog item = new TableCatalog();
        item.setId(102);
        item.setTitle("lion king");
        item.setBookAuthors(new HashSet<String>(Arrays.asList("Author 1")));

        mapper.save(item);
    }
}

