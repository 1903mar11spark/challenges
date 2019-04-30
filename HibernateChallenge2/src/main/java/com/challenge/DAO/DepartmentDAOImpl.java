package com.challenge.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.challenge.beans.Department;
import com.challenge.util.ConnectionUtil;


public class DepartmentDAOImpl implements DepartmentDAO{

	//variables 
	private SessionFactory sf = ConnectionUtil.getSessionFactory(); 

	//methods 
	@Override
	public Department getDepartmentById(int id) {
		Department d = null; 
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			d = s.get(Department.class,  id); 
			tx.commit();
		}
		return d; 
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> departments = new ArrayList<>(); 
		//use a Query to retrieve all caves 
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			departments = s.createQuery("from Department").getResultList(); 
			tx.commit();
			s.close();
		}
		return departments; 
	}

	@Override
	public void addDepartment(Department department) {
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
