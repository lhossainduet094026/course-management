package com.practice.coursemanagement.service;

import java.util.List;

import com.practice.coursemanagement.api.dto.CourseResponseDto;
import com.practice.coursemanagement.api.dto.ProfileCreateRequestDto;
import com.practice.coursemanagement.api.dto.ProfileResponseDto;
import com.practice.coursemanagement.api.dto.StudentResponseDto;
import com.practice.coursemanagement.api.dto.StudentUpdateRequestDto;
import com.practice.coursemanagement.model.Student;

public interface StudentService {

	Student saveStudent(Student student);
	
	Student update(Long studentId, Student student);
	
	void deleteStudent(Long studentId);
	
	Student findStudentByEmail(String email);
	
	Student findById(Long id);
	
	List<StudentResponseDto> findAllStudents();
	
	StudentResponseDto updateStudent(Long id, StudentUpdateRequestDto updateRequestDto);
	
	List<CourseResponseDto> findCoursesOfStudent(Long studentId);

	void enrollCourse(Long studentId, Long courseId);
	
	ProfileResponseDto createStudentProfile(Long studentId, ProfileCreateRequestDto profileCreateRequestDto);
}
