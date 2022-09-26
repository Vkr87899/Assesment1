package com.collegeapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collegeapp.models.College;
import com.collegeapp.repository.ICollegeRepository;
import com.collegeapp.service.ICollegeService;

@RestController
@RequestMapping("collge-app")
public class CollegeController {

	@Autowired
	ICollegeService collegeService;
	    @PostMapping( "/colleges")
		ResponseEntity<College> addCollege(@RequestBody College college)
		{
			collegeService.addCollege(college);
			return ResponseEntity.accepted().body(college);
		}
		
		
		//void deleteCollege(int collegeId);
		//void updateCollege(College college);
	    @GetMapping(path="/colleges/collegeId/{id}")
		ResponseEntity<College> getCollegeById( @PathVariable int id)
	    {
	    	College college=collegeService.getById(id);
	    	return ResponseEntity.status(HttpStatus.OK).build();
	    }
		//JPQL 
		//List<College>getByUniversity(String univerisityName);
		//List<College>getByCity(String universityCity);
		//List<College>getByDepartmentAndUniversity(String department, String univercityName);
}
