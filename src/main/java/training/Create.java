package training;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class Create extends TableCreator {
    public void createTable() {
        createUser(1, "Eduardo", 1, false);

    }

    private void createUser(Integer ghid, String title, Integer shelflife,Boolean  discontinued) {

            mapper = new DynamoDBMapper(client);
            System.out.println("Creating items!");
            CreateItems createItems = new CreateItems(ghid, title, shelflife, discontinued);

            mapper.save(createItems);
            System.out.println("User created!");

    }
}
