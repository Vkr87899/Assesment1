package com.collegeapp.service;

import java.util.List;

import com.collegeapp.models.University;

public interface IUniversityService {

	
	
	void addUniversity(University university);
	void deleteUniversity(int id);
	void updateUniversity(University university);
	University getById(int id);
	University getByCollege(String collegeName);
	List<University>getByCity(String city);
}
