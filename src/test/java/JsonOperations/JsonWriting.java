package JsonOperations;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonWriting {
	public static void main(String[] args) throws IOException {
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("name", "siraj");
		jsonObj.put("role", "cricket");
		jsonObj.put("age", 26);
		
		//JSON Array
		JSONArray jsonArray=new JSONArray();
		jsonArray.add("magical smile");
		jsonArray.add("magnetic eyes");
		jsonObj.put("spcil qotes", jsonArray);
		
		FileWriter fileWriter=new FileWriter("siraj.json");
		fileWriter.write(jsonObj.toJSONString());
		fileWriter.close();
				
	}

}
