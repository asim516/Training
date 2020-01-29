package training;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

public class EmployeesTest {

    @Test
    public void testEmployees() {

        Employees emp = new Employees();

        assertNotNull("app should have a greeting", emp.obj.toJSONString());
    }
}