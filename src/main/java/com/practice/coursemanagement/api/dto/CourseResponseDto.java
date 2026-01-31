package com.practice.coursemanagement.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

//`id` bigint unsigned NOT NULL AUTO_INCREMENT,
//`title` varchar(100) DEFAULT NULL,
//`description` varchar(100) DEFAULT NULL,
//`price` double DEFAULT '0',

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
