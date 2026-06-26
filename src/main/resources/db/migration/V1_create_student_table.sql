CREATE TABLE `students` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `profile_id` bigint unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `students_student_profiles_FK` (`profile_id`),
  CONSTRAINT `students_student_profiles_FK` FOREIGN KEY (`profile_id`) REFERENCES `student_profiles` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
