package com.hsbc.model;

import java.time.LocalDate;
import java.util.Comparator;

public class Employee  {

	
	int id;
	String name;
	double salary;
	LocalDate dob;
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Employee(int id, String name, double salary, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dob = dob;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getSalary() {
		return salary;
	}



	public void setSalary(double salary) {
		this.salary = salary;
	}



	public LocalDate getDob() {
		return dob;
	}



	public void setDob(LocalDate dob) {
		this.dob = dob;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", dob=" + dob + "]";
	}


//
//	@Override
//	public int compare(Employee o1, Employee o2) {
//		 
//		return o1.getName().compareTo(o2.getName());
//	}



 

 
	
	
}
