package com.ems.bdd_style;

import org.testng.annotations.Test;

//import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;// no need to mention RestAssured

import java.io.File;


public class EmployeeDetails {
	@Test(enabled=false)
	public void getAllEmpoyee() {
//		RestAssured
		given()
		.baseUri("http://localhost:3000/")
		.when()
		.get("employees")
		.prettyPrint();
	
	}
	@Test(enabled=false)
	public void createAnemployee() {
		given()
		.baseUri("http://localhost:3000/")
		.header("Content_Type","application/json")
		.body("{\"email\": \"kanima@retro.com\",\r\n" + 
				"    \"first_name\": \"kanima\",\r\n" + 
				"    \"last_name\": \"surya\"}")
		.when()
		.post("employees")
		.prettyPrint();		
	}
	@Test(enabled=false)
	public void updateEmployee() {
		given()
		.baseUri("http://localhost:3000/")
		.header("Content_type","application/json")
		.body("{\"email\": \"surya@retro.com\",\r\n" + 
				"    \"first_name\": \"sutya\",\r\n" + 
				"    \"last_name\": \"retro\"}")
		.when()
		.put("employees/8d67")
		.prettyPrint();
		
	}
	@Test(enabled=false)
	public void deleteAnEmployee() {
		given()
		.baseUri("http://localhost:3000/")
		.when()
		.delete("employees/bf26")
		.prettyPrint();
	}
	@Test
	public void createAnEmp() {
		File jsonfile=new File("postData.json");
		given()
		.baseUri("http://localhost:3000/")
		.header("Content_Type","application/json")
		.body(jsonfile)
		.when()
		.post("employees")
		.prettyPrint();
				
	}

}
