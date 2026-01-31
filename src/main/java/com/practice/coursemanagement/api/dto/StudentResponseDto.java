package com.practice.coursemanagement.api.dto;

import com.practice.coursemanagement.model.Student;

import lombok.Data;

@Data
public class StudentResponseDto {

	private Long id;

	private String email;

	private String name;

	public static StudentResponseDto fromEntity(Student student) {

		StudentResponseDto responseDto = new StudentResponseDto();

		responseDto.setEmail(student.getEmail());
		responseDto.setName(student.getName());
		responseDto.setId(student.getId());

		return responseDto;

	}
}
