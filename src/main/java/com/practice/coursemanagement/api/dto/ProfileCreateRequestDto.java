package com.practice.coursemanagement.api.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProfileCreateRequestDto {

	private String phone;

	private String address;

	private LocalDate dob;
}
