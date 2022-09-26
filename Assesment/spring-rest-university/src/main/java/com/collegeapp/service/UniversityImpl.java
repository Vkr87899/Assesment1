package com.collegeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegeapp.exceptions.UniversityNotFoundException;
import com.collegeapp.models.University;
import com.collegeapp.repository.IUniversityRepository;
@Service
public class UniversityImpl implements  IUniversityService{
	IUniversityRepository universityRepository;
	

	@Autowired
	public void setUniversityRepository(IUniversityRepository universityRepository) {
		this.universityRepository = universityRepository;
	}

	@Override
	public void addUniversity(University university) {
		// TODO Auto-generated method stub
		universityRepository.save(university);
	}

	@Override
	public void deleteUniversity(int id) {
		universityRepository.deleteById(id);
		
	}

	@Override
	public void updateUniversity(University university) {
		universityRepository.save(null);
		
		
	}

	@Override
	public University getById(int id) {
		
		University university= universityRepository.findById(id).get();
		if(university==null)
			throw new UniversityNotFoundException();
		return university;
				
	}

	@Override
	public University getByCollege(String collegeName) {
		// TODO Auto-generated method stub
		return universityRepository.findByCollege(collegeName);
	}

	@Override
	public List<University> getByCity(String city) {
		// TODO Auto-generated method stub
		List<University>universities=universityRepository.findByCity(city);
		if(universities.isEmpty())
			throw new UniversityNotFoundException();
		return universities;
	}

}
