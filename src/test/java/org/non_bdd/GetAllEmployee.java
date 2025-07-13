package org.non_bdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllEmployee {
	
	@Test(enabled=false)
	
	public void getAllEmployees() {
		RestAssured.baseURI="http://localhost:3000/";
		RequestSpecification requestSpecification = RestAssured.given();
		Response response = requestSpecification.request(Method.GET, "employees");
		System.out.println(response.asPrettyString());
		System.out.println(response.statusCode() +"  "+ response.getStatusLine());
		
	}
	@Test(enabled=false)
	public void creatAnEmployee() {
		RestAssured.baseURI="http://localhost:3000/";
		RequestSpecification requestSpecification=
		RestAssured.given().header("Content_Type","application/json")
		.body("{\r\n" +  
				"    \"email\": \"rahman@reqres.in\",\r\n" + 
				"    \"first_name\": \"rahman\",\r\n" + 
				"    \"last_name\": \"AR\"\r\n" + 
				"  }");
		Response response=requestSpecification.request(Method.POST, "employees");
		System.out.println(response.statusLine());
		System.out.println(response.asPrettyString());
		
		
	}
	@Test(enabled=false)
	public void updateEmployee() {
		RestAssured.baseURI="http://localhost:3000/";
		RequestSpecification requestSpecification
		=RestAssured
		.given()
		.header("Content_Type","application/json")
		.body("{\r\n" + 
				"    \"email\": \"ISAI@reqres.in\",\r\n" + 
				"    \"first_name\": \"ISAI\",\r\n" + 
				"    \"last_name\": \"iniyal\"\r\n" + 
				"  }");

		Response response = requestSpecification.request(Method.PUT, "employees/e463");
		System.out.println(response.asPrettyString());
	}
	@Test
	public void deleteAnEmployee() {
		RestAssured.baseURI="http://localhost:3000/";
		RequestSpecification requestSpecification
		= RestAssured
		.given();

		Response response=requestSpecification.request(Method.DELETE,"employees/b135");
		System.out.println(response.asPrettyString());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
