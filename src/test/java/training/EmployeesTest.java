package training;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

public class EmployeesTest {

    @Test
    public void testEmployees() throws JsonProcessingException {

         String[] emp =new String[]{"asim","mahida","anam","ahmed"};

        String result = new ObjectMapper().writeValueAsString(emp);
        assertEquals(Arrays.toString(emp),(Arrays.toString(new Employees().getTheName())));


    }


}