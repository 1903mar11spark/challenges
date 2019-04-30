package com.challenge;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.challenge.DAO.DepartmentDAO;
import com.challenge.DAO.DepartmentDAOImpl;
import com.challenge.DAO.EmployeeDAO;
import com.challenge.DAO.EmployeeDAOImpl;
import com.challenge.beans.Department;
import com.challenge.beans.Employee;
import com.challenge.util.ConnectionUtil;

import oracle.net.aso.s;

public class Driver {

	//main method 
	public static void main(String[] args) {
		
		/*
		 * HIBERNATE CODE CHALLENGE: Employees and Departments
		 * 
		 * On your branch in this repository (you will need to pull this project from the master branch),
		 * 1. configure this project with Hibernate, using either a resources file or environment variables
		 * to handle connection details
		 * 2. add the necessary mappings to Employee and Department to establish the multiplicity relationship
		 * 3. create implementing classes for the EmployeeDAO and DepartmentDAO
		 * 4. use your DAO methods in this class to 
		 * 		(a) populate at least three departments and six employees
		 * 		(b) demonstrate retrieval, updating, and deleting of both types of entity 
		 * After each numbered step is complete, be sure to push it to your branch with a commit message
		 * indicating which step is expressed therein.
		 */
		
		SessionFactory sf = ConnectionUtil.getSessionFactory();

		
		//adding first department table 
		/*
		
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();

		//Department d1 = new Department(1, "Accounting");  
		
		//s.save(d1); 
		
		tx.commit();
		
		s.close();
		*/
		
	
		//DAOs
		DepartmentDAO dd =  new DepartmentDAOImpl(); 
		EmployeeDAO ed = new EmployeeDAOImpl(); 
		
		/*
		Department d1 = new Department("Accounting"); ; 
		Department d2 = new Department("Human Resources");  
		Department d3 = new Department("Information Technology");
	
		dd.addDepartment(d1);
		dd.addDepartment(d2);
		dd.addDepartment(d3);
		*/
		
		/*
		System.out.println(dd.getAllDepartments());
		*/
	
		/*
		Employee e1 = new Employee(1, "Steve", "Smith"); 
		e1.setDepartment(new Department(28, "Accounting"));
		ed.updateEmployee(e1); 
		*/
		
		/*
		Department d1 = new Department("Accounting");   //insertion 
		Department d2 = new Department("IT"); 
		Department d3 = new Department("HR");
	
		dd.addDepartment(d1);
		dd.addDepartment(d2);
		dd.addDepartment(d3);
		*/
		
		/*
		Department d1 = dd.getDepartmentById(31);   //retrieval 
		
		System.out.println(d1);
		Employee e1 = new Employee("Steve", "Smith"); 
		e1.setDepartment(d1);
		System.out.println(e1);
		ed.addEmployee(e1); 
		
		System.out.println(d1);
		Employee e2 = new Employee("Adam", "Andrews"); 
		e2.setDepartment(d1);
		System.out.println(e2);
		ed.addEmployee(e2); 
		*/
		
		/*
		Department d2 = dd.getDepartmentById(32);    
		
		System.out.println(d2);
		Employee e3 = new Employee("Mary", "Manning"); 
		e3.setDepartment(d2);
		System.out.println(e3);
		ed.addEmployee(e3); 
		
		System.out.println(d2);
		Employee e4 = new Employee("Andrew", "Anderson"); 
		e4.setDepartment(d2);
		System.out.println(e4);
		ed.addEmployee(e4); 
		*/
		
		/*
		Department d3 = dd.getDepartmentById(33);    
		
		Employee e5 = new Employee("Katie", "Kinder"); 
		e5.setDepartment(d3);
		ed.addEmployee(e5); 
		
		Employee e6 = new Employee("Michael", "Moore"); 
		e6.setDepartment(d3);
		ed.addEmployee(e6);
		*/
		
		//add third person to IT 
		/*
		Department d4 = dd.getDepartmentById(31); 
		
		Employee e5 = new Employee("Jonathon", "Jetty"); 
		e5.setDepartment(d4);
		ed.addEmployee(e5); 
		*/
		
		//change Jonathon's department (i.e. demonstrate update) 
		/*
		Department d = dd.getDepartmentById(32);
		Employee e = new Employee(44, "Jonathon", "Jetty"); 
		e.setDepartment(d);
		ed.updateEmployee(e); 
		*/
		
		//jonathon leaves company (i.e. deletion of record) 
		Employee e = new Employee(44, "Jonathon", "Jetty"); 
		ed.deleteEmployee(e);
		

	}
	
	//other methods here
	

}