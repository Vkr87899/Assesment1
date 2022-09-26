package com.collegeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.collegeapp.exceptions.CollegeNotFoundExceptions;
import com.collegeapp.models.College;
import com.collegeapp.repository.ICollegeRepository;

@Service
public class CollegeServiceImpl implements ICollegeService {
	
	
	ICollegeRepository collegeRepository;
	@Autowired
	public void setCollegeRepository(ICollegeRepository collegeRepository) {
		this.collegeRepository = collegeRepository;
	}


	@Override
	public void addCollege(College college) {
	
	     collegeRepository.save(college);

	}

	@Override
	public void deleteCollege(int collegeId) {
		collegeRepository.deleteById(collegeId);
		
	}

	@Override
	public void updateCollege(College college) {
	   collegeRepository.save(college);
		
	}

	@Override
	public College getById(int id) {
		 
		College college= collegeRepository.findById(id).get();
		if(college==null)
			throw new CollegeNotFoundExceptions("College Id not found");
		return college;
	}

	@Override
	public List<College> getByUniversity(String univerisityName) {
		// TODO Auto-generated method stub
		List<College>colleges= collegeRepository.findByUniversity(univerisityName);
		if(colleges.isEmpty())
		{
			throw new CollegeNotFoundExceptions("Collgege Not Found");
		}
		return colleges;
	}

	@Override
	public List<College> getByCity(String universityCity) {
		// TODO Auto-generated method stub
		return collegeRepository.findByCity(universityCity);
	}

	@Override
	public List<College> getByDepartmentAndUniversity(String department, String univercityName) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
