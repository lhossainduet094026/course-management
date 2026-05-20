package com.practice.coursemanagement.api.common;

public class ErrorResponse {

	public static <T> ApiResponse<T> of(String message, T data) {
		return new ApiResponse<T>(false, message, data);
	}

	public static <T> ApiResponse<T> of(String message) {
		return new ApiResponse<T>(false, message, null);
	}
}
