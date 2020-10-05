package com.hsbc.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.dao.DaoImpl;
import com.hsbc.model.Employee;

public class MainClass {

	public static void main(String[] args) {
		 
		DaoImpl dao = new DaoImpl();
		dao.add();
		dao.getEmployees();
		System.out.println();
		System.out.println("************** sorting by name");
		dao.sorting(1);
		dao.getEmployees();
		
		System.out.println();
		System.out.println("************** sorting by id ");
		dao.sorting(2);
		dao.getEmployees();
		
		System.out.println();
		System.out.println("************** sorting by dob");
		dao.sorting(3);
		dao.getEmployees();
		
		System.out.println();
		System.out.println("************** sorting by salary");
		dao.sorting(4);
		dao.getEmployees();
		
		System.out.println();
		System.out.println("************** Top 3 Employees");
		dao.sorting(4);
		dao.getTopEmployees();
		
		System.out.println();
		System.out.println("************** Top 3 Employees(Descending salary)");
		dao.sorting(5);
		dao.getTopEmployees();
		
	}

}
