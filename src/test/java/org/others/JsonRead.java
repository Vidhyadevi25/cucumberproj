package org.others;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonRead {
	public static void readJson() throws IOException, ParseException {
		JSONParser js = new JSONParser();
		FileReader fr = new FileReader( System.getProperty("user.dir")+"\\src\\test\\resources\\simpleJson\\simple.json");
		Object obj = js.parse(fr);
		JSONObject j=(JSONObject) obj;
		System.out.println("page: "+ j.get("page"));
		Object data = j.get("data");
		System.out.println(data);
		JSONArray ar=(JSONArray)data;
		
		System.out.println(ar.get(3));
		for (Object x : ar) {
			//System.out.println(x);
			JSONObject j1=(JSONObject)x;
			System.out.println("id: " +j1.get("id"));
			System.out.println("first_name: "+j1.get("first_name"));
			System.out.println("last_name: "+j1.get("last_name"));
			System.out.println("email:" +j1.get("email"));
			System.out.println("avatar: "+j1.get("avatar"));
			System.out.println("============");
			
		}
	}
	public static void main(String[] args) throws IOException, ParseException {
		readJson();
		
	}

}
