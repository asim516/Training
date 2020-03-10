package training;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;

import java.util.Arrays;

public class TableCreator {


    public void createTable(String accessId,String accessSecret){
        BasicAWSCredentials awsCreds = new BasicAWSCredentials( accessId,accessSecret);

        AmazonDynamoDB client;

        client = AmazonDynamoDBClient.builder().withCredentials(new AWSStaticCredentialsProvider(awsCreds)).withRegion(Regions.EU_WEST_2).build();
        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = null;
        try {
            String tableName = "Movies";


            System.out.println("Attempting to create table; please wait..");
            table = dynamoDB.createTable(tableName,
                    Arrays.asList(new KeySchemaElement("year", KeyType.HASH), // Partition
                            // key
                            new KeySchemaElement("title", KeyType.RANGE)), // Sort key
                    Arrays.asList(new AttributeDefinition("year", ScalarAttributeType.N),
                            new AttributeDefinition("title", ScalarAttributeType.S)),
                    new ProvisionedThroughput(10L, 10L));

            table.waitForActive();
            System.out.println("Success.  Table status: " + table.getDescription().getTableStatus());

        } catch (Exception e) {


            System.out.println("Unable to create table: ");
            System.err.println(e.getMessage());
        }
        System.out.println("Reached create table");
        System.out.println( accessId );
        System.out.println( accessSecret);

    }
}
