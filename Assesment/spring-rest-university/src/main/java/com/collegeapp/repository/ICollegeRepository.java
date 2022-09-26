package com.collegeapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.collegeapp.models.College;


@Repository
public interface ICollegeRepository extends JpaRepository<College, Integer> {
	@Query("FROM College c INNER JOIN c.university u WHERE u.universityName=?1")
	List<College>findByUniversity(String univerisityName);
    @Query("FROM College c INNER JOIN  c.university u WHERE u.city=?1")
	List<College>findByCity(String universityCity);
	@Query("From College c INNER JOIN c.university u INNER JOIN c.departments d WHERE d.departmentName=?1 and u.universityName=?2 ")
	List<College>findByDepartmentAndUniversity(String department, String universityName);
	

}
