package com.challenge.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.challenge.beans.Department;
import com.challenge.util.ConnectionUtil;

import org.hibernate.SessionFactory;
import java.util.*;




public class DepartmentDAOImpl implements DepartmentDAO {

	private SessionFactory sf = ConnectionUtil.getSessionFactory();
	
	@Override
	public Department getById(int id) {
		Department d = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			d = (Department) s.get(Department.class, id);
			tx.commit();
		    s.close();
		}
		return d;
	}
	
	@Override
	public List<Department> getAll() {
		List<Department> departs = new ArrayList<>();

		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			departs = s.createQuery("from Department").getResultList();
			tx.commit();
			s.close();
		}
		return departs;
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
		try (Session s = sf.getCurrentSession()) {
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
