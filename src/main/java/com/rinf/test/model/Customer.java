package com.rinf.test.model;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;



@JsonbPropertyOrder({ "id", "name", "email","phoneNo"})
public class Customer {

	@JsonbProperty("id")
	private long id;
	
	@JsonbProperty("email")
	private String email;
	
	@JsonbProperty("name")
	private String name;
	
	@JsonbProperty("phoneNo")
	private String phoneNo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	

	 
}
