package com.practice.coursemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.coursemanagement.api.common.ApiResponse;
import com.practice.coursemanagement.api.common.SuccessResponse;
import com.practice.coursemanagement.api.dto.StudentCreateRequestDto;
import com.practice.coursemanagement.api.dto.StudentResponseDto;
import com.practice.coursemanagement.model.Student;
import com.practice.coursemanagement.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@PostMapping
	public ResponseEntity<ApiResponse> createUser(@Valid @RequestBody StudentCreateRequestDto studentCreateRequestDto) {

		Student persistentStudent = studentService.saveStudent(studentCreateRequestDto.toEntity());
		StudentResponseDto studentResponseDto = StudentResponseDto.fromEntity(persistentStudent);

		return new ResponseEntity<ApiResponse>(SuccessResponse.of("Student created", studentResponseDto), HttpStatus.CREATED);
	}
}
