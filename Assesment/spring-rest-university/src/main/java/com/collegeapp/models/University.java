package com.collegeapp.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class University {

	@Id
	@GeneratedValue(generator = "uni_gen" ,strategy =GenerationType.AUTO)
	@SequenceGenerator(name = "uni_gen" ,sequenceName = "uni_seq",initialValue = 100,allocationSize = 1)
	private Integer universityId;
	private String universityName;
	private String city;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "university_id")
	private Set<College> colleges;
	public University() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public University(String universityName, String city) {
		super();
		this.universityName = universityName;
		this.city = city;
	}

	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Set<College> getColleges() {
		return colleges;
	}
	public void setColleges(Set<College> colleges) {
		this.colleges = colleges;
	}
	public Integer getUniversityId() {
		return universityId;
	}

	@Override
	public String toString() {
		return "University [universityName=" + universityName + ", city=" + city + "]";
	}
	
}
