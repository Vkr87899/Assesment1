package com.collegeapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Address {

	@Id
	@GeneratedValue(generator = "add_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "add_gen",sequenceName = "add_seq" ,initialValue = 200,allocationSize = 1)
	private Integer addressId;
	private String state;
	private String city;
	private int zipcode;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String state, String city, int zipcode) {
		super();
		this.state = state;
		this.city = city;
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + ", zipcode=" + zipcode + "]";
	}
	
}
