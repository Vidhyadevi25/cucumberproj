
package com.ems.pojo_concepts;

import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Employee1 {
	public static void main(String[] args) throws JsonProcessingException {
		Employee employee1=new Employee();
		employee1.setFirstName("vid");
		employee1.setLastname("thiya");
		employee1.setEmail("vid@thiya@gmail.com");
		employee1.setSkills(Arrays.asList("java","selenium","API"));
		
		System.out.println(employee1.getFirstName());
		System.out.println(employee1.getLastname());

		System.out.println(employee1.getEmail());
		System.out.println(employee1.getSkills());
		
		ObjectMapper mapper=new ObjectMapper();
		String empJson=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee1);
		System.out.println(empJson);
		
	}

}
