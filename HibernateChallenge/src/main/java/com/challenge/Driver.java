package com.challenge;

import org.hibernate.SessionFactory;

import com.challenge.DAO.DepartmentDAO;
import com.challenge.DAO.DepartmentDAOImpl;
import com.challenge.DAO.EmployeeDAO;
import com.challenge.DAO.EmployeeDAOImpl;
import com.challenge.beans.Department;
import com.challenge.beans.Employee;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		
		/*
		 * HIBERNATE CODE CHALLENGE: Employees and Departments
		 * 
		 * On your branch in this repository (you will need to pull this project from the master branch),
		 * 1. configure this project with Hibernate, using either a resources file or environment variables
		 * to handle connection details
		 * 
		 * 2. add the necessary mappings to Employee and Department to establish the multiplicity relationship
		 * 
		 * 3. create implementing classes for the EmployeeDAO and DepartmentDAO
		 * 
		 * 4. use your DAO methods in this class to 
		 * 		(a) populate at least three departments and six employees
		 * 		(b) demonstrate retrieval, updating, and deleting of both types of entity 
		 * After each numbered step is complete, be sure to push it to your branch with a commit message
		 * indicating which step is expressed therein.
		 */
		SessionFactory sf = ConnectionUtil.getSessionFactory();
		
				EmployeeDAO bd = new EmployeeDAOImpl();
				DepartmentDAO db = new DepartmentDAOImpl();
				Department a = new Department(1, "Archery");
				db.createDepartment(a); 
				Employee b = new Employee(1, "Emily", "Baillie", a);
				bd.createEmployee(b);
	}

	
}
