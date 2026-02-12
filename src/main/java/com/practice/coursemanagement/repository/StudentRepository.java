package com.practice.coursemanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.coursemanagement.api.dto.CourseResponseDto;
import com.practice.coursemanagement.api.dto.StudentResponseDto;
import com.practice.coursemanagement.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	Optional<Student> findByEmail(String email);

	@Query("Select new com.practice.coursemanagement.api.dto.StudentResponseDto(s.id, s.email, s.name) From Student s ")
	List<StudentResponseDto> findAllStudents();
	
	@Query("Select new com.practice.coursemanagement.api.dto.CourseResponseDto(c.id, c.title, c.description, c.price) From Student s join s.courses c where s.id =:studentId")
	List<CourseResponseDto> findCoursesOfStudent(Long studentId);
	
	@Query("Select new com.practice.coursemanagement.api.dto.StudentResponseDto(s.id, s.email, s.name) From Student s ")
	Page<StudentResponseDto> findPaginatedStudents(Pageable pageable);
}
