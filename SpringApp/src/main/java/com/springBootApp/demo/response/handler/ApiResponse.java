package com.springBootApp.demo.response.handler;

public class ApiResponse {

	private Object message;
	private String status;

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
