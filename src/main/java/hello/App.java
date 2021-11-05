package hello;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("----------app----------");
        String fileName = "./src/test/resources/user.json";
//        readJosnToString_(fileName);
        readJsonToObject(fileName);
        System.out.println("----------app end----------");
    }

    private static void readJosnToString_(String fileName) throws IOException {
        String json = new String(Files.readAllBytes(Paths.get(fileName)));
        System.out.println(json);
    }

    private static void readJsonToObject(String fileName) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(fileName);
        Object obj = jsonParser.parse(reader);
        JSONObject jsonObj = (JSONObject) obj;
        String id = (String) jsonObj.get("id");
        String name = (String) jsonObj.get("name");
        String email = (String) jsonObj.get("email");
        System.out.println(id + " " + name + " "+ email);

        JSONArray addresses = (JSONArray) jsonObj.get("address");
        for (Object address : addresses) {
            JSONObject jsonAddress = (JSONObject) address;
            System.out.println(jsonAddress);

            String city = (String)jsonAddress.get("city");
            System.out.println(city);
        }
    }
}