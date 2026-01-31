package com.practice.coursemanagement.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//CREATE TABLE `student_profiles` (
//		  `id` bigint unsigned NOT NULL,
//		  `phone` varchar(100) DEFAULT NULL,
//		  `address` varchar(100) DEFAULT NULL,
//		  `date_of_birth` date DEFAULT NULL,
//		  `student_id` bigint unsigned NOT NULL,
//		  PRIMARY KEY (`id`),
//		  KEY `student_profiles_students_FK` (`student_id`),
//		  CONSTRAINT `student_profiles_students_FK` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`) ON DELETE CASCADE
//		) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

@Entity
@Table(name = "student_profiles")
public class StudentProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String phone;
	
	private String address;
	
	@Column(name = "date_of_birth")
	private LocalDate dob;
}
