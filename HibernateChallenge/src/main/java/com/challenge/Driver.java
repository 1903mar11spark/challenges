package com.challenge;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.challenge.DAO.DepartmentDAO;
import com.challenge.DAO.DepartmentDAOImpl;
import com.challenge.DAO.EmployeeDAO;
import com.challenge.DAO.EmployeeDAOImpl;
import com.challenge.beans.Department;
import com.challenge.beans.Employee;
import com.challenge.util.ConnectionUtil;

public class Driver {
	
public static void main(String[] args) {
	
	SessionFactory sf = ConnectionUtil.getSessionFactory();
	Session s = sf.openSession();
	System.out.println(s.getStatistics());
	s.close();
	
	DepartmentDAO deptDAO = new DepartmentDAOImpl();
	Department it = new Department(1, "IT");
	Department sales = new Department(2, "SALES");
	Department hr = new Department(3, "HR");
	
	deptDAO.createDepartment(it);
	deptDAO.createDepartment(sales);
	deptDAO.createDepartment(hr);
	
	
	EmployeeDAO ed = new EmployeeDAOImpl();
	Employee e1 = new Employee(1,"Herbert", "Wells", new Department(1, "IT"));
	Employee e2 = new Employee(2,"Sherlock", "Homes", new Department(1, "IT"));
	Employee e3 = new Employee(3, "John", "Watson", new Department(3, "HR"));
	Employee e4 = new Employee(4, "Mary", "Watson", new Department(2, "SALES"));
	Employee e5 = new Employee(5, "George", "Kirby", new Department(3, "HR"));
	Employee e6 = new Employee(6, "Sally", "Willson", new Department(2, "SALES"));
	
	ed.createEmployee(e1);
	ed.createEmployee(e2);
	ed.createEmployee(e3);
	ed.createEmployee(e4);
	ed.createEmployee(e5);
	ed.createEmployee(e6);
	
	ed.getById(2);//retreiving Sherlock Homes
	deptDAO.getAll();//retreiving all departmens
	
	e3.setDepartment(it);//change e3 department from sales to it
	ed.updateEmployee(e3);//updating e3's department
	
	deptDAO.deleteDepartment(sales);//deleting sales dept
	ed.deleteEmployee(e6);//deleting emp 6
	
	
	/*
	 *  * BatDAO bd = new BatDAOImpl(); 
	 * Bat b6 = new Bat(1,"Batty McBatFace", 20.0);
	 * b.setCave(new Cave(27, "Tampa", 8)); 
	 * bd.updateBat(b6);
	 */
		
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
