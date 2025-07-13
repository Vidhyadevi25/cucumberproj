package com.lao.json_path_with_java;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.testng.annotations.Test;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class RreadingJsonDocument {
	
	@Test
	public static void readJson() throws IOException {
		File jsonFile=new File("src/test/resources/bookstore.json");
		List<Object> pricelist = JsonPath.read(jsonFile, "$..price");
		for(Object price:pricelist) {
			System.out.println(price);
		}
	}
	@Test
	public static void readJson2() throws IOException {
		File jsonFile=new File("src/test/resources/bookstore.json");
		List<Object> authorList = JsonPath.read(jsonFile, "$..book[?(@.author)].author");
		for(Object author:authorList) {
			System.out.println(author);
		}
		System.out.println("---------------");
	}
	@Test 
	public static void parseOneTime() throws IOException {

		//		InputStream jsonFile=new ByteArrayInputStream("src/test/resources/bookstore.json".getBytes(StandardCharsets.UTF_8));
		//	FileReader jsonFile=new FileReader("src/test/resources/bookstore.json");
		//parse one Time
		String filepath="src/test/resources/bookstore.json";
		Path path = Paths.get(filepath);
		byte[] bytes = Files.readAllBytes(path);
		String jsonContent = new String(bytes,StandardCharsets.UTF_8);


		Object parse = Configuration
				.defaultConfiguration()
				.jsonProvider()
				.parse(jsonContent);
		List<Object> categoryList = JsonPath.read(parse, "$..category");
		for(Object category:categoryList) {
			System.out.println("category: "+category);
		}

		
		
		
	}
	@Test
	public static void fluentAPI() throws IOException {
		File jsonFile=new File("src/test/resources/bookstore.json");
		DocumentContext context = JsonPath.parse(jsonFile);
		List<Object> authorList = context.read("$..author");
		for(Object author:authorList) {
			System.out.println(author);
		}
		System.out.println("==============");
		
		Configuration configuration = Configuration.defaultConfiguration();
		List<Object> categoryList = JsonPath
		.using(configuration)
		.parse(jsonFile)
		.read("$..category");
		for(Object category:categoryList  ) {
			System.out.println(category);

		}
	}
	
	public static void main(String[] args) throws IOException {
		readJson();
		readJson2();
		parseOneTime();
		fluentAPI();
		
	}

	
}
