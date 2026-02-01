package com.practice.coursemanagement.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseResponseDto {

	private Long id;

	private String title;

	private String description;
	
	private double price;

	public CourseResponseDto(Long id, String title, String description, double price) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
	}

}
