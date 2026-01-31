package com.practice.coursemanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//CREATE TABLE `lessons` (
//		  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
//		  `video_url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
//		  `duration` double DEFAULT NULL,
//		  `title` varchar(100) DEFAULT NULL,
//		  `course_id` bigint unsigned NOT NULL,
//		  PRIMARY KEY (`id`),
//		  KEY `lessons_courses_FK` (`course_id`),
//		  CONSTRAINT `lessons_courses_FK` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`) ON DELETE CASCADE
//		) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

@Entity
@Table(name = "lessons")
public class Lesson {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String video_url;
	
	private String title;
	
	private double duration;
}
