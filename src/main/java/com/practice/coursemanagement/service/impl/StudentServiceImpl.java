package com.practice.coursemanagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.coursemanagement.api.dto.StudentResponseDto;
import com.practice.coursemanagement.api.dto.StudentUpdateRequestDto;
import com.practice.coursemanagement.exception.ResourceAlreadyExistException;
import com.practice.coursemanagement.exception.ResourceNotFoundException;
import com.practice.coursemanagement.model.Student;
import com.practice.coursemanagement.repository.StudentRepository;
import com.practice.coursemanagement.service.StudentService;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Transactional
	@Override
	public Student saveStudent(Student student) {

		studentRepository.findByEmail(student.getEmail())
		.orElseThrow(() -> new ResourceAlreadyExistException("Student already exist with :" + student.getEmail()));

		return studentRepository.save(student);
	}

	@Transactional
	@Override
	public Student update(Long studentId, Student student) {
		student.setId(studentId);
		return studentRepository.save(student);
	}

	@Transactional
	@Override
	public void deleteStudent(Long studentId) {
		studentRepository.deleteById(studentId);
	}

	@Override
	public Student findStudentByEmail(String email) {

		Optional<Student> existingEmail = studentRepository.findByEmail(email);

		return existingEmail.orElseThrow(() -> new ResourceAlreadyExistException("Student already exist with :" + email));
	}

	@Override
	public Student findById(Long id) {
		
		 Optional<Student> student = studentRepository.findById(id);
		 
		 return student.orElseThrow(() -> new ResourceNotFoundException("Student not found with id:"+ id));
	}

	@Override
	public List<StudentResponseDto> findAllStudents() {
		return studentRepository.findAllStudents();
	}

	@Override
	public StudentResponseDto updateStudent(Long id, StudentUpdateRequestDto updateRequestDto) {
		
		 Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
			            "Student not found with id: " + id));
		
		 student.setEmail(updateRequestDto.getEmail());
		 student.setName(updateRequestDto.getName());
		 
		 student = saveStudent(student);
		 
		 return StudentResponseDto.fromEntity(student);
	}
}
