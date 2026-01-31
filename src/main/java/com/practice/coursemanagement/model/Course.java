package com.practice.coursemanagement.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

//CREATE TABLE `courses` (
//		  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
//		  `title` varchar(100) DEFAULT NULL,
//		  `description` varchar(100) DEFAULT NULL,
//		  `price` double DEFAULT '0',
//		  PRIMARY KEY (`id`)
//		) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

@Entity
@Table(name = "courses")
@Data
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String description;
	
	private double price;
	
	@ManyToMany(mappedBy = "courses")
	private Set<Student> students = new HashSet<>();
}
