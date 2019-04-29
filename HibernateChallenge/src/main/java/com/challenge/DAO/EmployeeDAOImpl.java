package com.challenge.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.challenge.beans.Department;
import com.challenge.beans.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImpl {
	
	SessionFactory sf = ConnectionUtil.getSessionFactory();
	
	public Employee getById(int id) {
		Employee emp = new Employee();
		
		return emp;
	}
	public List<Employee> getByDepartment(Department department){
		
	}
	
	public void createEmployee(Employee employee) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.save(employee);
		tx.commit();
		s.close();
	}
	public void updateEmployee(Employee employee) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.save(employee);
		tx.commit();
		s.close();
	}
	public void deleteEmployee(Employee employee) {
		
	}

}
