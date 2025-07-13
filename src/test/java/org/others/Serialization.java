package org.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Serialization {
	//data is obtained
	@Test
	public void serialization() {
		Map<String,Object> jsonBody=new HashMap<String,Object>();
		jsonBody.put("first_name", "micky");
		jsonBody.put("last_name", "mouse");
		jsonBody.put("email", "mocky@mouse.com");
		
		List<String> skills=new LinkedList<String>();
		skills.add("java");
		skills.add("selenium");
		skills.add("API");
		
		jsonBody.put("skills", skills);
		System.out.println(jsonBody);
		
		given()
		.baseUri("http://localhost:3000/")
		.header("Content-Type","application/json")
		.body(jsonBody)
		.log()
		.all()
		.when()
		.post("employees")
		.then()
		.log()
		.all();
		
		
		
		
	}

}
