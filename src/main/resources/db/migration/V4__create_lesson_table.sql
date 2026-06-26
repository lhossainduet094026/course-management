CREATE TABLE `lessons` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `video_url` varchar(255) DEFAULT NULL,
  `duration` double DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `course_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `lessons_courses_FK` (`course_id`),
  CONSTRAINT `lessons_courses_FK` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
