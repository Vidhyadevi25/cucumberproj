package com.lao.json_path_with_java;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.jayway.jsonpath.JsonPath;

public class InlinePredicateExample {
	File jsonFile=new File("src/test/resources/bookstore.json");
	
	private void inlinePredicate() throws IOException {
		//[?(@.price<10)] predicate
		List<Object> result=JsonPath
				.parse(jsonFile)
				.read("$.store.book[?(@.price<10 && @.category=='fiction')]");
		
		//price < 10 && category = fiction
		//[?(@.price<10 && @.category=='fiction')]
		
		//price>10 || category='reference'
		//[?(@.price>10 || category=='reference')]
		
		
		System.out.println(result);
	}
	public static void main(String[] args) throws IOException {
		
		InlinePredicateExample example=new InlinePredicateExample();
		example.inlinePredicate();
		
	}
}
