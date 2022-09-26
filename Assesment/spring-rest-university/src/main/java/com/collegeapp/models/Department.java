package com.collegeapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Department {
    @Id
    @GeneratedValue(generator = "dep_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "dep_gen",sequenceName = "dep_seq",initialValue = 50,allocationSize = 1)
    private Integer departmentId; 
    private String departmentName;
    @Column(length = 35)
    private String departmentHead;
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(String departName, String departmentHead) {
		super();
		this.departmentName = departName;
		this.departmentHead = departmentHead;
	}
	@Override
	public String toString() {
		return "Department [departName=" + departmentName + ", departmentHead=" + departmentHead + "]";
	}
    
}
