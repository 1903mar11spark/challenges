package com.challenge.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.challenge.beans.Department;
import com.challenge.beans.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private SessionFactory sf = ConnectionUtil.getSessionFactory();

	public Employee getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> getByDepartment(Department department) {

		List<Employee> employee = new ArrayList<>();
		// use a Query to retrieve all caves
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			employee = s.createQuery("from Employee").getResultList();
			tx.commit();
			s.close();
		}
			return employee;
	}

	public void createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(employee);
			tx.commit();
			s.close();
}
	}

	public void updateEmployee(Employee employee) {
			
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.update(employee);
			tx.commit();
			s.close();
}
		
	}

	public void deleteEmployee(Employee employee) {
		
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(employee);
			tx.commit();
			s.close();
}
		
	}

}
