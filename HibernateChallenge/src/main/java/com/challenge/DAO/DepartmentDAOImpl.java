package com.challenge.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.challenge.beans.Department;
import com.revature.util.ConnectionUtil;


public class DepartmentDAOImpl implements DepartmentDAO{
	
	private SessionFactory sf = ConnectionUtil.getSessionFactory();

	public Department getById(int id) {
		Department c = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			c = (Department) s.get(Department.class, id);
			tx.commit();
			// s.close();
		}
		return c;
	}

	public List<Department> getAll() {
		List<Department> depts = new ArrayList<>();
		// use a Query to retrieve all caves
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			depts = s.createQuery("from Dept").getResultList();
			tx.commit();
			s.close();
		}
		return depts;

	}

	public void createDepartment(Department department) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(department);
			tx.commit();
			s.close();
		}
	}

	public void updateDepartment(Department department) {
		try ( Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.update(department);
			tx.commit();
			s.close();
		}	
	}

	public void deleteDepartment(Department department) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(department);
			tx.commit();
			s.close();
		}
		
	}

}
