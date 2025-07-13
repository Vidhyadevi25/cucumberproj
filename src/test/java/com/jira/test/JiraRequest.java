package com.jira.test;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class JiraRequest {
	public static void main(String[] args) {
		
		baseURI="https://kmutechgridproj.atlassian.net";
		Response res = given().
		header("Content-Type","application/json").
		auth().preemptive().
		basic("vidhyadevi.k96@gmail.com", "ATATT3xFfGF0FpWfQXw1qzsTjwySrZxPZg7K88XPIEPZqf5mSBLVnMah6M1HKM-_pNbfqPNFtYYaS4yhu18M9MItbkVDk9BMawBhXI-zVifpjnmlcgXO2WNzdPXnd5FO7F4jm_5NO3ipA3LCOmCOVmC6s1FMxD1mTafBEw9Qlsh1Fk4PWMN1DyA=0DE0B121").
		when().get("rest/api/2/search");
		System.out.println(res.getStatusCode());
		System.out.println(res.getBody().asString());
		System.out.println("-------------");
	}

}
