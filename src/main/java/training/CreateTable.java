package training;

import java.util.Arrays;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;  
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;

public class CreateTable {

    public static void main(String[] args) throws Exception {
        System.out.println("Hii.");
        try {
        CreateTable createTable = new CreateTable();
        AmazonDynamoDB client;
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIASAQI2P2W4FOVXUMI", "5BenzeDNLgMlWwElnlPgNwr5Rh7E4fRdNWBsW0ei");
        client = AmazonDynamoDBClient.builder().withCredentials(new AWSStaticCredentialsProvider(awsCreds)).withRegion(Regions.EU_WEST_2).build();

        DynamoDB dynamoDB = new DynamoDB(client);


        String tableName = "Movies";


            System.out.println("Attempting to create table; please wait..");
            Table table = dynamoDB.createTable(tableName,
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
    }
}





