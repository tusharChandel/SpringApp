package com.springBootApp.demo.exception;

import java.util.Date;

public class ErrorMessage {

	private Date timestamp;
	private String message;
	//private Object errorObject;
	private String error;

	public ErrorMessage() {

	}

	public ErrorMessage(String message, String error) {
		super();
		//this.errorObject = errorObject;
		this.message = message;
		this.error = error;
		this.timestamp = new Date();
	}

	public Date getTimestamp() {
		return timestamp;
	}
	
	public String getMessage() {
		return message;
	}

	public Object getError() {
		return error;
	}

	@Override
	public String toString() {
		return "ErrorMessage [timestamp=" + timestamp + ", message=" + message + ", error=" + error + "]";
	}
	
}
