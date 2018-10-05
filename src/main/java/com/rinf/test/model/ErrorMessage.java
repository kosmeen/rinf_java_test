package com.rinf.test.model;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({ "id", "name", "email","phoneNo"})
public class ErrorMessage {
	
	@JsonbProperty("message")
	private String message;
	
	@JsonbProperty("code")
	private int code;
	
	public ErrorMessage() {
			
		}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	

}
