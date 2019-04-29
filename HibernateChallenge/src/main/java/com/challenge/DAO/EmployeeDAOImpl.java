package com.challenge.DAO;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.challenge.beans.Department;
import com.challenge.util.ConnectionUtil;


import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.challenge.beans.Department;
import com.challenge.beans.Employee;
import com.challenge.util.ConnectionUtil;


public class EmployeeDAOImpl implements EmployeeDAO {
	
	private SessionFactory sf = ConnectionUtil.getSessionFactory();


	@Override
	public Employee getById(int id) {
		Employee e = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			e = (Employee) s.get(Employee.class, id);
			tx.commit();
			// s.close();
		}
		return e;
	}

	@Override
	public List<Employee> getByDepartment(Department department) {
		return null;
//		List<Department> dept = new ArrayList<>();
//		// use a Query to retrieve all caves
//		try (Session s = sf.getCurrentSession()) {
//			Transaction tx = s.beginTransaction();
//			dept = s.createQuery("from Department").getResultList();
//			tx.commit();
//			s.close();
//		}
//		return dept;
	}

	@Override
	public void createEmployee(Employee employee) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(employee);
			tx.commit();
			s.close();
		}
		
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = (Transaction) s.beginTransaction();
			s.update(employee);
			tx.commit();
			return true;
		} catch (Exception e) {
			return false;
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
