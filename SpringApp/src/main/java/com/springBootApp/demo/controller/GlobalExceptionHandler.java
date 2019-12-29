package com.springBootApp.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springBootApp.demo.exception.ErrorMessage;
import com.springBootApp.demo.exception.LoginIdAlreadyRegisteredException;
import com.springBootApp.demo.exception.UserLoginIdNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	// UserLoginIdNotFoundException
	@ExceptionHandler(UserLoginIdNotFoundException.class)
	public final ResponseEntity<Object> handleUserLoginIdNotFoundException(UserLoginIdNotFoundException ex,
			WebRequest request) {
		ErrorMessage errorMessage = new ErrorMessage("From UserLoginIdNotFound Exception ", ex.getMessage());
		System.out.println(errorMessage);
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}

	// LoginIdAlreadyRegisteredException
	@ExceptionHandler(LoginIdAlreadyRegisteredException.class)
	public final ResponseEntity<Object> handleLoginIdAlreadyRegisteredException(LoginIdAlreadyRegisteredException ex,
			WebRequest request) {
		ErrorMessage errorMessage = new ErrorMessage("From LoginIdAlreadyRegisteredException Exception ",
				ex.getMessage());
		System.out.println(errorMessage);
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}

	// MethodArgumentNotValidException
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
		
		ErrorMessage errorMessage = new ErrorMessage("MethodArgumentNotValid Exception ",
				errors.toString());
		
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
		ErrorMessage errorMessage = new ErrorMessage("ConstraintViolation Exception ",
				ex.getMessage());
		// System.err.println(errorMessage);
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}

	// HttpRequestMethodNotSupported
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ErrorMessage errorMessage = new ErrorMessage(
				"HttpRequestMethodNotSupported Exception - Method Not Allowed ", ex.getMessage());
		// System.err.println(errorMessage);
		return new ResponseEntity<>(errorMessage, HttpStatus.METHOD_NOT_ALLOWED);
	}

	// NoHandlerFoundException
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		ErrorMessage errorMessage = new ErrorMessage(
				"NoHandlerFound Exception - No service found for given request ",
				ex.getMessage());
		// System.err.println(errorMessage);
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}

	// HttpMediaTypeNotSupportedException
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ErrorMessage errorMessage = new ErrorMessage(
				"HttpMediaTypeNotSupported Exception - Media Type is not supported for given request ",
				ex.getMessage());
		// System.err.println(errorMessage);
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		ErrorMessage errorMessage = new ErrorMessage("TypeMismatch Exception ", ex.getMessage());
		System.err.println(errorMessage);
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);

	}

}
