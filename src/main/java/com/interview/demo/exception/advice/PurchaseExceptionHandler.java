package com.interview.demo.exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.interview.demo.exception.DataNotFoundException;

@ControllerAdvice
public class PurchaseExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<String> handleException(DataNotFoundException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
