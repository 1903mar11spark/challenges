package com.challenge.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.challenge.beans.Department;
import com.challenge.beans.Employee;
import com.challenge.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO{


	SessionFactory sf = ConnectionUtil.getSessionFactory();
	
	@Override
	public Employee getById(int id) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		Employee e = s.get(Employee.class, id); 
	
		tx.commit();
		s.close();
		return e;
	}

	@Override
	public List<Employee> getByDepartment(Department department) {
		List<Employee> list = new ArrayList<Employee>();
		Session s = sf.openSession();
			Transaction tx = s.beginTransaction();
			String hql = "FROM Employee WHERE department= :dep";
			Query q = s.createQuery(hql);
			q.setParameter("dep", department);
			list = q.list();
			tx.commit();
		return list;
	}

	@Override
	public void createEmployee(Employee employee) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.save(employee);
	
		tx.commit();
		s.close();
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.update(employee);
	
		tx.commit();
		s.close();
	}

	@Override
	public void deleteEmployee(Employee employee) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.delete(employee);
	
		tx.commit();
		s.close();
		
	}

}
