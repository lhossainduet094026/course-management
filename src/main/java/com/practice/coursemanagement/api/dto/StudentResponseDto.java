package com.practice.coursemanagement.api.dto;

import com.practice.coursemanagement.model.Student;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentResponseDto {

	private Long id;

	private String email;

	private String name;

	public StudentResponseDto(Long id, String email, String name) {
		this.id = id;
		this.email = email;
		this.name = name;
	}

	public static StudentResponseDto fromEntity(Student student) {

		StudentResponseDto responseDto = new StudentResponseDto();

		responseDto.setEmail(student.getEmail());
		responseDto.setName(student.getName());
		responseDto.setId(student.getId());

		return responseDto;

	}
}
