package com.collegeapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.collegeapp.models.Address;
import com.collegeapp.models.College;
import com.collegeapp.models.Department;
import com.collegeapp.models.University;
import com.collegeapp.service.ICollegeService;
import com.collegeapp.service.IUniversityService;

@SpringBootApplication
public class SpringRestUniversityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestUniversityApplication.class, args);
	}
	@Autowired
     ICollegeService collegeService;
	@Autowired
	IUniversityService universityService;
	@Override
	public void run(String... args) throws Exception {
	   Address address =new Address("Delhi","delhi", 56005);
	   Department department1=new Department("IT", "Vikas");
	   Department department2=new Department("Chemical", "Zabba");
	   Department department3=new Department("Mechanical", "Dr.Sashi");
	   
	   Set<Department>departmentList=new HashSet<>(Arrays.asList(department1,department2, department3));
	   
	  College college1=new College( "Kashi Enginnering college",departmentList, address,universityService.getById(101));
	  // University university1=new  University("Gauhati University", "Guwahati");
	   //University university2=new University("Kasar University", "Shilong");
	   //universityService.addUniversity(university1);
	  // universityService.addUniversity(university2);
	  collegeService.addCollege(college1);
		//collegeService.getByUniversity("Kasar University").forEach(System.out::println);
	}

}
