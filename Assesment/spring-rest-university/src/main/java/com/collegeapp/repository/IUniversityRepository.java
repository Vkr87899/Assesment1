package com.collegeapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.collegeapp.models.University;

@Repository
public interface IUniversityRepository extends JpaRepository<University, Integer> {

	@Query("FROM University u INNER JOIN u.colleges c WHERE c.collegeName=?1")
	University findByCollege(String collegeName);
	@Query(value = "select u.university_name from university u inner join college c on c.university_id=u.university_id inner join address a on c.address_address_id=a.address_id and a.city=?1",nativeQuery = true)
	List<University>findByCity(String city);
	
}
