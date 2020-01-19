package training;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Employees {

    @SuppressWarnings("unchecked")

    JSONObject obj = new JSONObject();

    {


        JSONArray employee = new JSONArray();
        employee.add("Asim");
        employee.add("Bilal");
        employee.add("Azeem");

        obj.put("employee-name", employee);

        try {

            FileWriter file = new FileWriter("data.json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}






