package com.lao.json_path_with_java;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.Configuration.ConfigurationBuilder;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

public class ConfigurationsExamples {
	
	public static void main(String[] args) {
		
		String json="[\r\n" + 
				"  {\"firstName\":\"John\", \"lastName\":\"Doe\"},\r\n" + 
				"  {\"firstName\":\"Anna\", \"lastName\":\"Smith\"},\r\n" + 
				"  {\"firstName\":\"Peter\", \"lastName\":\"Jones\"}\r\n" + 
				"]";
		Configuration config=Configuration.defaultConfiguration();
		
		config=config.addOptions(Option.SUPPRESS_EXCEPTIONS);
		//config=config.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
//		// if i need to store the single or multiple values in the List
//		config = config.addOptions(Option.ALWAYS_RETURN_LIST);
		
		
		//if we know before the PathNotFoundException we can go for this
//		Configuration config = Configuration.builder().options(Option.DEFAULT_PATH_LEAF_TO_NULL).build();
		
		String result = JsonPath
		.using(config)
		.parse(json)
		.read("$.[1].lastname");
		System.out.println(result);
	}

}
