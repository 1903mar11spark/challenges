package com.challenge.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.challenge.beans.Department;
import com.challenge.beans.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImpl {
	
	SessionFactory sf = ConnectionUtil.getSessionFactory();
	
	public Employee getById(int id) {
		Session s = sf.openSession();
		Employee emp = new Employee();
		emp = s.get(Employee.class, id);
		s.close();
		return emp;
	}
	public List<Employee> getByDepartment(Department department){
		Session s = sf.openSession();
		Query q = s.getNamedQuery("getAllEmployees");
		List<Employee> empList = q.getResultList();
		s.close();
		return empList;
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
		s.update(employee);
		tx.commit();
		s.close();
	}
	public void deleteEmployee(Employee employee) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.delete(employee);
		tx.commit();
		s.close();
	}

}
