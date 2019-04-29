package com.challenge;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.challenge.DAO.DepartmentDAOImpl;
import com.challenge.DAO.EmployeeDAOImpl;
import com.challenge.beans.Department;
import com.challenge.beans.Employee;
import com.revature.util.ConnectionUtil;
//beans go here

public class Driver {

	static EmployeeDAOImpl eDAO = new EmployeeDAOImpl();
	static DepartmentDAOImpl dDAO = new DepartmentDAOImpl();
	
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
		//Create departments
		/*Department dept = new Department ("Heroics");
		dDAO.createDepartment(dept);
		dept = new Department ("Support");
		dDAO.createDepartment(dept);
		dept = new Department ("Management");
		dDAO.createDepartment(dept);*/
			
		//Add employees
		
		Department heroics = new Department (1);
		Department support = new Department (2);
		Department management = new Department (3);
		
		Employee emp = new Employee("Thor", "Odinson", heroics);
		eDAO.createEmployee(emp);
		emp = new Employee("Steve", "Rogers",heroics );
		eDAO.createEmployee(emp);
		emp = new Employee("Peter", "Parker", support);
		eDAO.createEmployee(emp);
		emp = new Employee("Tony", "Stark", support);
		eDAO.createEmployee(emp);
		emp = new Employee("Bruce", "Banner", support);
		eDAO.createEmployee(emp);
		emp = new Employee("Nick", "Fury", management);
		eDAO.createEmployee(emp);
		
		
		

	}

}
