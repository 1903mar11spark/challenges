package com.challenge.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.challenge.beans.Department;
import com.challenge.beans.Employee;
import com.challenge.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private SessionFactory sf = ConnectionUtil.getSessionFactory();

	@Override
	public Employee getById(int id) {
		Employee e = new Employee();
		try(Session s = sf.openSession()) {
			e = s.get(Employee.class, id);
			
		}
		return e;
	}

	@Override
	public List<Employee> getByDepartment(Department department) {
		List<Employee> employees = new ArrayList<>();
		try(Session s = sf.openSession()){
				Transaction tx = s.beginTransaction();
				employees = s.createQuery("from Employee").getResultList();
				tx.commit();
				s.close();
		}
		return employees;
	}

	@Override
	public void createEmployee(Employee employee) {
		Employee e = new Employee();
		try(Session s = sf.openSession()){
			Transaction tx = s.beginTransaction(); 
			s.save(employee);
		  tx.commit(); 
		  s.close(); 
		  }

	}

	@Override
	public void updateEmployee(Employee employee) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.update(employee);
			tx.commit();
			s.close();
		}

	}

	@Override
	public void deleteEmployee(Employee employee) {
		try(Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			s.delete(employee);
			tx.commit();
			s.close();
		}

	}

}
