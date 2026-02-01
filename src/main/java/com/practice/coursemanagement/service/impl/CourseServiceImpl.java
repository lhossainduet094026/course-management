package com.practice.coursemanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.coursemanagement.api.dto.LessonResponseDto;
import com.practice.coursemanagement.exception.ResourceNotFoundException;
import com.practice.coursemanagement.repository.CourseRepository;
import com.practice.coursemanagement.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	private CourseRepository courseRepository;

	@Autowired
	public CourseServiceImpl(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@Override
	public List<LessonResponseDto> findLessonOfCourse(Long courseId) {

		if (!courseRepository.existsById(courseId)) {
			throw new ResourceNotFoundException("Course not found with id" + courseId);
		}

		return courseRepository.findLessonsOfCourse(courseId);
	}
}
