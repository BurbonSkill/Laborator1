import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.LinkedHashMap;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CreatJson {
    public static void main(String[] args) {

        JSONObject obj = new JSONObject();
        JSONArray ja = new JSONArray();
        Map m0 =new LinkedHashMap();

        Map m = new LinkedHashMap();
        m.put("Stea", "Soare");
        m.put("Nume", "Pamant");

        m.put("Descoperire", "-");
        m.put("viata", "true");
        obj.put("idPlaneta = 0001", m);

        JSONArray list = new JSONArray();
        list.add("Luna");

        m.put("sateliti", list);

        Map m1 = new LinkedHashMap();

        m1.put("Stea", "Soare");
        m1.put("Nume", "Mercur");
        m1.put("Descoperire", "-1000");

        m1.put("viata", "false");
        obj.put("idPlaneta = 0002", m1);
        JSONArray list1 = new JSONArray();
        list1.add("-");

        m1.put("sateliti", list1);




        try (FileWriter file = new FileWriter("planete.json")) {
            file.write(obj.toJSONString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);

    }
}
