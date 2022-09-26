package com.collegeapp.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;





@Entity
public class College {

	@Id
	@GeneratedValue(generator = "college_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "college_gen",sequenceName = "college_seq",initialValue = 1000,allocationSize = 1)
	private Integer collegeId;
	private String collegeName;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
     @JoinColumn(name="college_id")
	private Set<Department>departments;
	@ManyToOne()
	@JoinColumn(name = "university_id")
	private University university;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}
	public College(String collegeName, Set<Department> departments, Address address, University university) {
		super();
		this.collegeName = collegeName;
		this.departments = departments;
		this.address = address;
		this.university=university;
	}
	public Integer getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}
	public University getUniversity() {
		return university;
	}
	public void setUniversity(University university) {
		this.university = university;
	}
	@Override
	public String toString() {
		return "College [collegeName=" + collegeName + ", departments=" + departments + ", address=" + address + "]";
	}
	
}
