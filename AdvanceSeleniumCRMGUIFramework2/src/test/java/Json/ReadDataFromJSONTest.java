package Json;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJSONTest {

	public static void main(String[] args) throws IOException, ParseException {
		// step 1 : Parse JSON physical file into java object using JSONParser class
		JSONParser par = new JSONParser();
		Object obj = par.parse(new FileReader("C:\\Users\\User\\Desktop\\data\\appCommonData.json"));
		// step2 : Convert java object into JSON object using down Casting
		JSONObject map =(JSONObject) obj;
		// step3: get the value from Json file using key
		System.out.println(map.get("browser"));
		System.out.println(map.get("url"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("timeout"));
	}

}
