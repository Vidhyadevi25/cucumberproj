package com.lao.json_path_with_java;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;
import com.jayway.jsonpath.Predicate.PredicateContext;

public class CustomPredicate {
	File jsonFile=new File("src/test/resources/bookstore.json");

	public void myCustomPredicate() throws IOException {
		
		/*Predicate bookWithISBN = new Predicate() {
			
			@Override
			public boolean apply(PredicateContext ctx) {
				boolean predicate=ctx.item(Map.class).containsKey("isbn");
				return predicate ;	}};*/
		
		Predicate bookWithISBN=ctx->ctx.item(Map.class).containsKey("isbn");	
		List<Map<String,Object>> result = JsonPath.parse(jsonFile)
		.read("$.store.book[?].isbn",List.class,bookWithISBN);
		System.out.println(result);
		
		 
	}
	public static void main(String[] args) throws IOException {
		CustomPredicate exe=new CustomPredicate();
		exe.myCustomPredicate();
	}

}
