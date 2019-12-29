package com.springBootApp.demo.exception;

import java.util.List;

public class ApplicationException extends Exception {

	private String parameter;
	private Object errorObject;
	private ErrorMessage errorMessage;
	private List<ErrorMessage> errorMessages;

	private static final long serialVersionUID = 1L;

	public ApplicationException() {
		super();	
	}

	public ApplicationException(String parameter, Object error) {
		super();
		this.parameter = parameter;
		this.errorObject = error;
	}

	public ApplicationException(String parameter, String error) {
		super();
		this.parameter = parameter;
	}

	public ApplicationException(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;

	}

	public ApplicationException(List<ErrorMessage> errorMessages) {
		this.errorMessages = errorMessages;

	}

	public ApplicationException(String parameter) {
		this.parameter = parameter;
	}

	@Override
	public String getMessage() {
		return parameter;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public List<ErrorMessage> getErrorMessages() {
		return errorMessages;
	}

	public Object getError() {
		return errorObject;
	}

	public void setError(Object error) {
		this.errorObject = error;
	}
	
	

}
