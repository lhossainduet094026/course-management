package com.practice.coursemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practice.coursemanagement.api.dto.LessonResponseDto;
import com.practice.coursemanagement.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	@Query("Select new com.practice.coursemanagement.api.dto.LessonResponseDto(l.id, l.videoUrl, l.title, l.duration) From Course c JOIN c.lessons l where c.id =:courseId")
	List<LessonResponseDto> findLessonsOfCourse(@Param("courseId") Long courseId);
}
