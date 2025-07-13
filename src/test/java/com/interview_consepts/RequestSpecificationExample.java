 package com.interview_consepts;

import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationExample {
	RequestSpecification rs;
	@BeforeSuite
	public void setRequest() {
		rs = given()
		.baseUri("http://localhost:3000/")
		.basePath("employees");
		RestAssured.requestSpecification=rs;
	}
	@Test(enabled=true)
	public void getAnEmployeeB() {
		given()
		.when()
		.delete("/5bd6")
		.prettyPrint();
		
		
	}
	@Test(enabled=false)
	public void getAllEmployeeB() {
		given()
		.when()
		.get()
		.prettyPrint();
		
		
	}
	@Test
	public void createAnEmp() {
		RequestSpecification specify=given()
				.contentType(ContentType.JSON)
				.baseUri("http://localhost:3000");
		
		
		given()
		.spec(specify) 
		.body("{\r\n" + 
				"    \"Name\": \"chair\",\r\n" + 
				"    \"Role\": \"head\",\r\n" + 
				"    \"Age\": 200\r\n" + 
				"  }")
		.when()
		.post("/employees")
		.prettyPrint();
		
		
	}

}
