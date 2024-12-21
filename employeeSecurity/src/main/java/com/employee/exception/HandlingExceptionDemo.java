package com.employee.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlingExceptionDemo {

	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String employeeNotFoundException(EmployeeNotFoundException empNotFound) {
		return empNotFound.getMessage();
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> methodArgumentNotValidException(
			MethodArgumentNotValidException methodArgumentNotValidException) {
		List<FieldError> fieldErrors = methodArgumentNotValidException.getBindingResult().getFieldErrors();
		Map<String, String> eachError = new HashMap<>();
		for (FieldError fieldError : fieldErrors) {
			eachError.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return eachError;
	}
}
