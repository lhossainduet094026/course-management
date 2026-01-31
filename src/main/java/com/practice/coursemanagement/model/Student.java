package com.practice.coursemanagement.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

//CREATE TABLE `students` (
//		  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
//		  `name` varchar(100) DEFAULT NULL,
//		  `email` varchar(100) DEFAULT NULL,
//		  PRIMARY KEY (`id`)
//		) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

@Entity
@Table(name = "students")
@Data
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String email;

	@ManyToMany
	@JoinTable(name = "student_courses", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Set<Course> courses = new HashSet<>();

	public void addCourse(Course course) {
		courses.add(course);
		course.getStudents().add(this);
	}

	public void removeCourse(Course course) {
		courses.remove(course);
		course.getStudents().remove(this);
	}
}
