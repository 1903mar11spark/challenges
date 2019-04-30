package com.challenge.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.challenge.beans.Department;
import com.challenge.beans.Employee;
import com.challenge.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	
	// variables
	private SessionFactory sf = ConnectionUtil.getSessionFactory();
	

	@Override
	public Employee getEmployeeById(int id) {
		Employee e = null; 
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			e = s.get(Employee.class,  id); 
			tx.commit();
		}
		return e; 
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>(); 
		//use a Query to retrieve all caves 
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			employees = s.createQuery("from Employee").getResultList(); 
			tx.commit();
			s.close();
		}
		return employees; 
	}



	@Override
	public boolean updateEmployee(Employee employee) {
		//this is awesome. We use session and the hibernate methods here 
		//and NOT JDBC's connection and other interfaces. 
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			s.update(employee);
			tx.commit(); 
			return true; 
		} catch (Exception e) {
			return false; 
		}
		
	}



	@Override
	public void addEmployee(Employee employee) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			s.persist(employee);
			tx.commit();
			s.close();
		}
	}

	@Override
	public void deleteEmployee(Employee employee) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			s.delete(employee); 
			tx.commit(); 
			s.close(); 
		}
	}

}
