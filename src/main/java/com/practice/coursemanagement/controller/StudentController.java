package com.practice.coursemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.coursemanagement.api.common.ApiResponse;
import com.practice.coursemanagement.api.common.SuccessResponse;
import com.practice.coursemanagement.api.dto.StudentCreateRequestDto;
import com.practice.coursemanagement.api.dto.StudentResponseDto;
import com.practice.coursemanagement.api.dto.StudentUpdateRequestDto;
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
	public ResponseEntity<ApiResponse<StudentResponseDto>> createStudent(
			@Valid @RequestBody StudentCreateRequestDto studentCreateRequestDto) {

		Student persistentStudent = studentService.saveStudent(studentCreateRequestDto.toEntity());
		StudentResponseDto studentResponseDto = StudentResponseDto.fromEntity(persistentStudent);

		return new ResponseEntity<ApiResponse<StudentResponseDto>>(
				SuccessResponse.of("Student created", studentResponseDto), HttpStatus.CREATED);
	}

//	GET	/api/v1/students/{id}	Get student by id
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<StudentResponseDto>> findStudent(@PathVariable Long id) {
		Student student = studentService.findById(id);
		return new ResponseEntity<ApiResponse<StudentResponseDto>>(
				SuccessResponse.of("Student found successfully", StudentResponseDto.fromEntity(student)), HttpStatus.OK);
	}

//	/api/v1/students List all students
	@GetMapping
	public ResponseEntity<ApiResponse<List<StudentResponseDto>>> findAllStudents() {
		return new ResponseEntity<ApiResponse<List<StudentResponseDto>>>(
				SuccessResponse.of("Students fetched successfully", studentService.findAllStudents()), HttpStatus.OK);
	}

//	/api/v1/students/{id}
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<StudentResponseDto>> updateStudent(@PathVariable Long id, @Valid @RequestBody StudentUpdateRequestDto studentUpdateRequestDto) {
		StudentResponseDto updateStudent = studentService.updateStudent(id, studentUpdateRequestDto);
		return new ResponseEntity<ApiResponse<StudentResponseDto>>(SuccessResponse.of("Student updated successfully", updateStudent), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
		return ResponseEntity.noContent().build();
	}
}
