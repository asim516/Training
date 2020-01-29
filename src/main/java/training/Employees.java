package training;

import java.io.FileWriter;
import java.io.IOException;
import com.fasterxml.jackson.annotation.JsonGetter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Employees {

    @SuppressWarnings("unchecked")

    JSONObject obj = new JSONObject();

    {
        JSONArray employee = new JSONArray();

        employee.add("Asim");
        employee.add("Mahida");
        employee.add("Anam");

        obj.put("name", employee);
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








