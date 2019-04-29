package com.challenge.DAO;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.challenge.beans.Department;
import com.challenge.util.ConnectionUtil;

public class DepartmentDAOImpl implements DepartmentDAO {
	
	private SessionFactory sf = ConnectionUtil.getSessionFactory();


	@Override
	public Department getById(int id) {
		Department d = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			d = (Department) s.get(Department.class, id);
			tx.commit();
			// s.close();
		}
		return d;
	}

	@Override
	public List<Department> getAll() {
		List<Department> dept = new ArrayList<>();
		// use a Query to retrieve all caves
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			dept = s.createQuery("from Department").getResultList();
			tx.commit();
			s.close();
		}
		return dept;
	}

	@Override
	public void createDepartment(Department department) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(department);
			tx.commit();
			s.close();
		}
		
	}

	@Override
	public void updateDepartment(Department department) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.update(department);
			tx.commit();
			s.close();
		}
		
	}

	@Override
	public void deleteDepartment(Department department) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(department);
			tx.commit();
			s.close();
		}
		
	}

}
