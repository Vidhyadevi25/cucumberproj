package com.restassured;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Deserialaiz {
	public static void main(String[] args) {
		RestAssured.baseURI="http://localhost:3000/";
		Response get = RestAssured.given().header("Content-Type","application/json")
						.when().get("employees");
		
		EmpDetails user=get.as(EmpDetails.class);
		System.out.println(user.getFirst_name());
		System.out.println(user.getLast_name());
		System.out.println(user.getEmail());
		List<String> skills = user.getSkills();
		for (String skill : skills) {
			System.out.println(skill);
		}
		
		
		
		
			
			
		}

}
