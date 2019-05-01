package com.challenge;

import com.challenge.DAO.DepartmentDAOImpl;
import com.challenge.DAO.EmployeeDAOImpl;

public class Driver {

	public static void main(String[] args) {
		
		
		DepartmentDAOImpl dd = new DepartmentDAOImpl();
		EmployeeDAOImpl ed = new EmployeeDAOImpl();

		
//	GET BY DEPARTMENT	
//		Department dep = new Department(1, "Accounting");
//		System.out.println(ed.getByDepartment(dep));
		
// GET EMP BY ID		
//		System.out.println(ed.getById(1));
		
// DELETE EMPLOYEE	
//		Employee emp = new Employee(2);
//		ed.deleteEmployee(emp);	
		
// UPDATE EMPLOYEE
//		Department dep = new Department(1, "Accounting");
//		Employee emp = new Employee(2, "Alfred", "Pennybags", dep);
//		ed.updateEmployee(emp);	
		
// CREATE NEW EMPLOYEES
//		Department dep = new Department(3, "Human Resources");
//		Employee emp = new Employee("That", "Guy", dep);
//		ed.createEmployee(emp);
		
		
		
		
//GET BY ID		
//		System.out.println(dd.getById(2));
		
// SHOW ALL DEPARTMENTS		
//		System.out.println(dd.getAll());
		
//CREATE NEW DEPT
//		Department dep = new Department ("Revature");
//		dd.createDepartment(dep);
//		System.out.println(dd.getAll());
	
//UPDATE DEPT
//		Department dep = new Department (12, "RevaturePro");
//		dd.updateDepartment(dep);
//		System.out.println(dd.getAll());
		
//DELETE DEPT
//		Department dep = new Department (12);
//		dd.deleteDepartment(dep);
//		System.out.println(dd.getAll());
		
		
		
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

	}
}
