package com.hsbc.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hsbc.model.Employee;

public class DaoImpl {

	List<Employee> emp = new ArrayList<Employee>();
	public void add() {
		
		Employee e1 = new Employee(1,"Aniket",50000, LocalDate.of(1998,4,17));
		emp.add(e1);
		Employee e2 = new Employee(62,"Charlie",3000, LocalDate.of(1991,9,23));
		emp.add(e2);
		Employee e3 = new Employee(3,"Binod",48000, LocalDate.of(1988,2,14));
		emp.add(e3);
		Employee e4 = new Employee(14,"Aladdin",15700, LocalDate.of(1983,4,12));
		emp.add(e4);
		Employee e5 = new Employee(5,"Zebra",10000, LocalDate.of(1998,1,07));
		emp.add(e5);
		Employee e6 = new Employee(6,"Genie",60000, LocalDate.of(1988,6,27));
		emp.add(e6);
		
		
	}
	
	public void getEmployees(){
		
		for(Employee e:emp) {
			System.out.println(e);
		}
		
	}
	
	public void getTopEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		int counter = 0;
		for(Employee e : emp) {
			employees.add(e);
			counter++;
			if(counter == 4) {
				break;
			}
			System.out.println(e);
		}
		
	}
	
	
	public void sorting(int choice) {
		if(choice ==1) {
			Collections.sort( emp, (e1, e2) -> e1.getName().compareTo(e2.getName()));
		}
		if(choice ==1) {
			Collections.sort( emp, (e1, e2) -> e1.getId() - e2.getId());
		}
		if(choice ==3) {
			Collections.sort( emp, (e1, e2) -> e1.getDob().compareTo(e1.getDob()));
		}
		if(choice ==4) {
			Collections.sort( emp, (e1, e2) -> (int)( e1.getSalary()-e2.getSalary()));
		}
		if(choice == 5) {
			Collections.sort( emp, (e1, e2) -> (int)( e2.getSalary()-e1.getSalary()));
		}
		
		
		
		
		
		 
	}
	
	
	
}
