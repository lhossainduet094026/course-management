package com.practice.coursemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.coursemanagement.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
