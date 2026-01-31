package com.practice.coursemanagement.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.practice.coursemanagement.api.common.ApiResponse;
import com.practice.coursemanagement.api.common.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceAlreadyExistException.class)
	public ResponseEntity<ApiResponse<ErrorResponse>> handleResourceExistException(ResourceAlreadyExistException e) {
		return new ResponseEntity<>(ErrorResponse.of(e.getMessage()), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse<?>> handleValidationErrors(MethodArgumentNotValidException exception) {
		Map<String, String> errors = new HashMap<>();
		List<ObjectError> allErrors = exception.getAllErrors();
		allErrors.forEach(e -> {
			String fieldName = ((FieldError) e).getField();
			String message = e.getDefaultMessage();
			errors.put(fieldName, message);
		});

		return new ResponseEntity<ApiResponse<?>>(ErrorResponse.of("Validation failed", errors), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<?>> handleAnyException(Exception ex) {
		return new ResponseEntity<ApiResponse<?>>(ErrorResponse.of("Something went wrong"), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
