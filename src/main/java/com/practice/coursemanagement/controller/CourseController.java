package com.practice.coursemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.coursemanagement.api.common.ApiResponse;
import com.practice.coursemanagement.api.common.SuccessResponse;
import com.practice.coursemanagement.api.dto.LessonResponseDto;
import com.practice.coursemanagement.service.CourseService;

@RestController
@RequestMapping("/v1/courses")
public class CourseController {

	private CourseService courseService; 

	@Autowired
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@GetMapping("/{courseId}/lessons")
	public ResponseEntity<ApiResponse<List<LessonResponseDto>>> findLessonOfCourse(@PathVariable("courseId") Long courseId){
		List<LessonResponseDto> lessons = courseService.findLessonOfCourse(courseId);
		return new ResponseEntity<ApiResponse<List<LessonResponseDto>>>(SuccessResponse.of("Lesson fetched successful", lessons), HttpStatus.OK);
	} 
}
