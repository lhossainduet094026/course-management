package com.practice.coursemanagement.api.dto;

import java.time.LocalDate;

import com.practice.coursemanagement.model.StudentProfile;

import lombok.Data;

@Data
public class ProfileResponseDto {

	private Long id;

	private String phone;

	private String address;

	private LocalDate dob;
	
	public static ProfileResponseDto fromEntity(StudentProfile studentProfile) {
		ProfileResponseDto profileResponseDto = new ProfileResponseDto();
		profileResponseDto.setId(studentProfile.getId());
		profileResponseDto.setPhone(studentProfile.getPhone());
		profileResponseDto.setDob(studentProfile.getDob());
		return profileResponseDto;
	}
}
