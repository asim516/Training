package training;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Objects;
import java.util.Set;

@DynamoDBTable(tableName = "igh")
public class CreateItems   {

    private  Integer ghid=0 ;
    private String title="";
    private Integer shelflife=0;
    private Boolean discontinued=false;


    public CreateItems()
    {

    }

    public CreateItems(Integer ghid, String title, Integer shelflife,Boolean  discontinued) {
        this.ghid = Objects.requireNonNull(ghid) ;
        this.title =  Objects.requireNonNull(title);
        this.shelflife =  Objects.requireNonNull(shelflife);
        this. discontinued =   Objects.requireNonNull(discontinued);
    }

    // Partition key
    @DynamoDBHashKey
    public Integer getGhid() {
        return ghid;
    }
    public void setGhid(Integer ghid) {
        this.ghid =Objects.requireNonNull(ghid) ;
    }

    @DynamoDBAttribute
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = Objects.requireNonNull(title);
    }

    @DynamoDBAttribute(attributeName = "shelflife")
    public Integer getShelflife() {
        return shelflife;
    }

    public void setShelflife (Integer shelflife) {
        this.shelflife = Objects.requireNonNull(shelflife);
    }

    @DynamoDBAttribute(attributeName = "discontinued")
    public Boolean getDiscontinued() {
        return discontinued ;
    }

    public void setDiscontinued(Boolean discontinued) {
        this.discontinued = Objects.requireNonNull(discontinued);
    }

    @Override
    public String toString() {
        return "ghid: " + getGhid()
                + ", shelflife: " + getShelflife()
                + ", discontinued: " + getDiscontinued()
                + ", title: " + getTitle();
    }
}