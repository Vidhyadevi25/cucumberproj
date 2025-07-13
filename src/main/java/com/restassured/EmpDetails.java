package com.restassured;

import java.util.List;

public class EmpDetails {
	
	private String first_name;
	private List<String> skills;
	private String last_name;
	private String email;
	
	
	public EmpDetails(String first_name, List<String> skills, String last_name, String email) {
		super();
		this.first_name = first_name;
		this.skills = skills;
		this.last_name = last_name;
		this.email = email;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	

}
