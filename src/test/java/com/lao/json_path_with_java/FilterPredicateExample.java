package com.lao.json_path_with_java;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import static com.jayway.jsonpath.Criteria.where;
import static com.jayway.jsonpath.Filter.filter;
import static com.jayway.jsonpath.JsonPath.parse;


import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;

public class FilterPredicateExample {
	File jsonFile=new File("src/test/resources/bookstore.json");

	
	public void filerAPI() throws IOException { 
		Filter priceLessThan = Filter.filter(Criteria.where("price").lt(12));
		List<Object> result = JsonPath.parse(jsonFile).read("$.store.book[?]",priceLessThan);
		System.out.println(result);
	}
	
	public void secondFilter() throws IOException {
		String key="category";
		Filter secondCriteria = Filter.filter(
				Criteria
				.where("price") 
				.lt(10)
				.and(key)
				.is("fiction"));
	//	List<Map<String,Object>> result = JsonPath.parse(jsonFile).read("$.store.book[?]",secondCriteria);
	//	System.out.println(result.get(0).get("author"));
		
		List<Object> result = JsonPath.parse(jsonFile).read("$.store.book[?]",secondCriteria);
		System.out.println(result.get(0));
		
	}
	public void thirdFilter() throws IOException {
		String key="category";
		Filter filter3 = filter(
				where("price")
				.gt(8)
				.and(key)
				.is("fiction"));
		List<Map<String,Object>> result =parse(jsonFile).read("$.store.book[?]",filter3);
		System.out.println(result);
	}	
	
	
	
	public static void main(String[] args) throws IOException {
		FilterPredicateExample exe=new FilterPredicateExample();
		exe.filerAPI();
		exe.secondFilter();
		exe.thirdFilter();
	

}

	
	
} 
