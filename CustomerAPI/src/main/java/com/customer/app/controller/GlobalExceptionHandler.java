package com.customer.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.customer.app.dto.ApiError;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiError methodArgumentNotValidException(MethodArgumentNotValidException exception) {
		BindingResult bindingResult=exception.getBindingResult();
		List<FieldError> fieldErrors=bindingResult.getFieldErrors();
		return new ApiError(HttpStatus.BAD_REQUEST.value(), "validation errors",
				fieldErrors.stream().map(e->e.getDefaultMessage()).collect(Collectors.toList()));
		
	}
	

}
