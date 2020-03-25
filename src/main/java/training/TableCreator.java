package training;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;

import java.util.Arrays;

public class TableCreator {
    protected DynamoDBMapper mapper;

    private String tableName;

    public  void createTable(String accessId, String accessSecret) {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessId, accessSecret);

        AmazonDynamoDB client;

        client = AmazonDynamoDBClient.builder().withCredentials(new AWSStaticCredentialsProvider(awsCreds)).withRegion(Regions.EU_WEST_2).build();
        DynamoDB dynamoDB = new DynamoDB(client);
        mapper = new DynamoDBMapper(client);
        Table table = null;
        try {
            String tableName = "igh";


            System.out.println("Attempting to create table; please wait..");
            table = dynamoDB.createTable(tableName,
                    Arrays.asList(new KeySchemaElement("ghid", KeyType.HASH)), // Partition
                    // key
                    Arrays.asList(new AttributeDefinition("ghid", ScalarAttributeType.N)),

                    new ProvisionedThroughput(10L, 10L));

            table.waitForActive();
            System.out.println("Success.  Table status: " + table.getDescription().getTableStatus());
create();
        } catch (Exception e) {


            System.out.println("Unable to create table: ");
            System.err.println(e.getMessage());
        }
    }
        public void create() {
            createUser(1, "Eduardo", 1, false);

        }

        private void createUser(Integer ghid, String title, Integer shelflife,Boolean  discontinued) {
            System.out.println("Creating items!");
            CreateItems  createItems= new CreateItems(ghid, title, shelflife, discontinued);

            mapper.save(createItems);
            System.out.println("User created!");
        }


    }
     

