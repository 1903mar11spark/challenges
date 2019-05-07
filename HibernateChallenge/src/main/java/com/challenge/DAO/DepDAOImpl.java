package com.challenge.DAO;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.challenge.beans.Department;
import com.challenge.util.ConnectionUtil;


public class DepDAOImpl implements DepartmentDAO{
	
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
		Session s = sf.openSession();
		Query q = s.getNamedQuery("getAllDepts");
		List<Department> deptList = q.getResultList();
	
		return deptList;


	}

	public void createDepartment(Department department) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.save(department);
		tx.commit();
		s.close();
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

