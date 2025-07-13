package JsonOperations;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class JsonReading {
	public static void main(String[] args) throws IOException, ParseException {
		JSONParser jsonparser=new JSONParser();
		FileReader fileReader=new FileReader("siraj.json");
		Object parseObj = jsonparser.parse(fileReader);
		
		JSONObject jsonobj=(JSONObject) parseObj;
		String name = (String)jsonobj.get("name");
		long age=(long)jsonobj.get("age");
		JSONArray array = (JSONArray)jsonobj.get("spcial qotes");
		Iterator iterator = array.iterator();
		System.out.println("name is: "+name);
		System.out.println("age is: "+age);

		while(iterator.hasNext()) {
			System.out.println("Spcial qotes: "+iterator.next());
		}
		
		
	
		
	}

}
