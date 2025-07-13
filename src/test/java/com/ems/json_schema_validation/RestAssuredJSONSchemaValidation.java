package com.ems.json_schema_validation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class RestAssuredJSONSchemaValidation {
	//public File inputJson;
	@Test(enabled=true)
	public void validationUsingJsonSchemaInClasspath() {
		File inputJson=new File("src\\test\\resources\\input.json");
		RestAssured
		.given()
		.baseUri("http://localhost:3000/")
		.header("Content-Type","application/json")
		.body(inputJson)
		.when()
		.post("employees")
		.then()
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"))
		.log()
		.all();	
	}
	@Test
	public void validationUsingMatchesJsonSchema() throws FileNotFoundException {
		File inputJson=new File("src\\test\\resources\\input.json");

//		InputStream inputSchema=new FileInputStream("src\\test\\resources\\schema.json");
		Reader inputSchema=new FileReader("src\\test\\resources\\schema.json");

		RestAssured
		.given()
		.baseUri("http://localhost:3000/")
		.header("Content_Type","application/json")
		.body(inputJson)
		.when()
		.post("employees")
		.then()
		.body(JsonSchemaValidator.matchesJsonSchema(inputSchema))
		.log().all();
		
	}

}
