package com.collegeapp.service;

import java.util.List;

import com.collegeapp.models.College;

public interface ICollegeService {

	//CRUD operations
	void addCollege(College college);
	void deleteCollege(int collegeId);
	void updateCollege(College college);
	College getById(int id);
	//JPQL 
	List<College>getByUniversity(String univerisityName);
	List<College>getByCity(String universityCity);
	List<College>getByDepartmentAndUniversity(String department, String univercityName);
	
}
