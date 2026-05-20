package com.practice.coursemanagement.api.dto;

import com.practice.coursemanagement.model.Student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StudentCreateRequestDto {

	@NotBlank(message = "Name is required")
	private String name;

	@NotBlank(message = "Email is required")
	@Email(message = "Email is invalid")
	private String email;

	public Student toEntity() {
		Student student = new Student();
		student.setEmail(email);
		student.setName(name);
		return student;
	}
}
