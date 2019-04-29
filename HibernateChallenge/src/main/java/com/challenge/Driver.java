package com.challenge;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.challenge.beans.Department;
import com.challenge.beans.Employee;
import com.challenge.util.ConnectionUtil;
import com.challenge.DAO.*;

public class Driver {

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
		DepartmentDAO departo = new DepartmentDAOImpl();
		SessionFactory sf = ConnectionUtil.getSessionFactory();
		//createEmployee(sf);
		
		Department d1 = new Department("Tech");
		Department d2 = new Department("Cooking");
		Department d3 = new Department("Housing");
		Department d4 = new Department("Music");
		
		departo.getById(1);
		//departo.createDepartment(d1);
		//departo.createDepartment(d2);
		//departo.createDepartment(d3);
		//departo.createDepartment(d4);
		
		
	}

	static void createEmployee(SessionFactory sf) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.save(new Employee("Cyan", "White"));
		s.save(new Employee("Chad", "Rogers"));
		s.save(new Employee("Matthew", "Red"));
		s.save(new Employee("Mew", "Rawr"));
		s.save(new Employee("Betty", " White"));
		tx.commit();
		s.close();
	}

}
