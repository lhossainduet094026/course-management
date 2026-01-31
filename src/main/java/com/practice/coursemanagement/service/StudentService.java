package com.practice.coursemanagement.service;

import com.practice.coursemanagement.model.Student;

public interface StudentService {

	Student saveStudent(Student student);
	
	Student update(Long studentId, Student student);
	
	void deleteStudent(Long studentId);
	
	Student findStudentByEmail(String email);
	
	Student findById(Long id);
}
