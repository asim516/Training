package training;

import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.Arrays;
import java.util.List;

public class Employees {

    @SuppressWarnings("unchecked")


    public String[] name = new String[]{"asim","mahida","anam","ahmed"};

    public String[] Employees( String[] empname) {
        String[] str= new String[4];


        str[0]=name[0];
        str[1]=name[1];
        str[2]=name[2];
        str[3]=name[3];
        return str;
    }

    @JsonGetter("name")
    public String[] getTheName() {

        return this.name;





    }
}






