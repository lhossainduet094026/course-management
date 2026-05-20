package com.practice.coursemanagement.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LessonResponseDto {

	private Long id;

	private String videoUrl;

	private String title;

	private double duration;

}
