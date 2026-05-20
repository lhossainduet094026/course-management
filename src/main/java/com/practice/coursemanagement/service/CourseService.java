package com.practice.coursemanagement.service;

import java.util.List;

import com.practice.coursemanagement.api.dto.LessonResponseDto;

public interface CourseService {

	List<LessonResponseDto> findLessonOfCourse(Long courseId);
}
