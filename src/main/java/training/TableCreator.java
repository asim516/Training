package training;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;

import java.util.Arrays;

public class TableCreator {
     AmazonDynamoDB client;


    private String tableName;

    public void createTable(String accessId, String accessSecret) {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessId, accessSecret);



        client = AmazonDynamoDBClient.builder().withCredentials(new AWSStaticCredentialsProvider(awsCreds)).withRegion(Regions.EU_WEST_2).build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = null;
        try {
            String tableName = "IGH";


            System.out.println("Attempting to create table; please wait..");
            table = dynamoDB.createTable(tableName,
                    Arrays.asList(new KeySchemaElement("gh", KeyType.HASH)), // Partition
                    // key
                    Arrays.asList(new AttributeDefinition("gh", ScalarAttributeType.N)),

                    new ProvisionedThroughput(10L, 10L));

            table.waitForActive();
            System.out.println("Success.  Table status: " + table.getDescription().getTableStatus());

        } catch (Exception e) {


            System.out.println("Unable to create table: ");
            System.err.println(e.getMessage());
        }
    }



    }
     

