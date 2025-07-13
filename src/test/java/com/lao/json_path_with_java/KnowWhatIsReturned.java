package com.lao.json_path_with_java;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class KnowWhatIsReturned {
	public static void main(String[] args) throws IOException {
		File jsonFile=new File("src/test/resources/bookstore.json");
		String author1 = JsonPath.read(jsonFile, "$.store.book[2].author");
		System.out.println(author1);

		List<Object> authorList = JsonPath.read(jsonFile, "$.store.book[0,1,2].author");
		for(Object author:authorList) {
			System.out.println(author);
		}
	}
	

}
