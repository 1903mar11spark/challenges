package com.challenge;


import com.challenge.beans.Employee;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.challenge.DAO.DepartmentDAO;
import com.challenge.DAO.DepartmentDAOImpl;
import com.challenge.DAO.EmployeeDAO;
import com.challenge.DAO.EmployeeDAOImpl;
import com.challenge.beans.Department;
import com.challenge.util.ConnectionUtil;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.challenge.beans.Department;
import com.challenge.beans.Employee;

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
		SessionFactory sf = ConnectionUtil.getSessionFactory();

		        makeEmployees(sf);
				//getAndLoad(sf);
//				 DepartmentDAO dd = new DepartmentDAOImpl();
//				 System.out.println(dd.getAll());
//			
		        
		        EmployeeDAO ed = new EmployeeDAOImpl();
				DepartmentDAO dd = new DepartmentDAOImpl();
				Department g = new Department(1, "guitars");
				dd.createDepartment(g); 
				Employee mick = new Employee(1, "mick", "mars", g);
				ed.createEmployee(mick);



	}
	
	static void makeDepartments(SessionFactory sf) {
		Department d = new Department();
		DepartmentDAO ddao = new DepartmentDAOImpl();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.save(new Department(1, "guitars"));
		s.save(new Department(2, "vocals"));
		s.save(new Department(3, "bass"));
		s.save(new Department(4, "drums"));
		tx.commit();
		s.close();
	}
	
	
	
	static void makeEmployees(SessionFactory sf) {
		Department g = new Department();
		Department v = new Department();
		Department b = new Department();
		Department d = new Department();

		

		DepartmentDAO ddao = new DepartmentDAOImpl();
		g = ddao.getById(1);
		v = ddao.getById(2);
		b = ddao.getById(3);
		d = ddao.getById(4);

		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.save(new Employee(1, "Ace", "Frehley", g));
		s.save(new Employee(2, "Vince", "Neil", v));
		s.save(new Employee(3, "Mick", "Mars", g));
		s.save(new Employee(4, "Gene", "Simmons", b));
		s.save(new Employee(5, "Tommy", "Lee", d));
		
		tx.commit();
		s.close();
	}

}
