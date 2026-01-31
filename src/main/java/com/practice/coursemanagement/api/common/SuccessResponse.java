package com.practice.coursemanagement.api.common;

public class SuccessResponse {

	public static <T> ApiResponse<T> of(String message, T data) {
		return new ApiResponse<T>(true, message, data);
	}

	public static <T> ApiResponse<T> of(String message) {
		return new ApiResponse<T>(true, message, null);
	}
}
