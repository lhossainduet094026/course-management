package com.practice.coursemanagement.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

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

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Lesson> lessons = new HashSet<>();

	public void addLesson(Lesson lesson) {
		lessons.add(lesson);
		lesson.setCourse(this);
	}

	public void removeLesson(Lesson lesson) {
		lessons.remove(lesson);
		lesson.setCourse(null);
	}
}
