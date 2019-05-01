package com.challenge.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.challenge.beans.Department;
import com.challenge.beans.Employee;
import com.challenge.util.ConnectionUtil;

public class DepartmentDAOImpl implements DepartmentDAO {
	
	private SessionFactory sf = ConnectionUtil.getSessionFactory();

	@Override
	public Department getById(int id) {
		Department d = new Department();
		try(Session s = sf.openSession()) {
			d = s.get(Department.class, id);
			
		}
		return d;
	}

	@Override
	public List<Department> getAll() {
		List<Department> dept = new ArrayList<>();
		try(Session s = sf.openSession()){
			Transaction tx = s.beginTransaction();
			dept = s.createQuery("from Department").getResultList();
			tx.commit();
			s.close();
		}
		return dept;
	}

	@Override
	public void createDepartment(Department department) {
		Department d = new Department();
		try(Session s = sf.openSession()){
			Transaction tx = s.beginTransaction(); 
			s.save(department);
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
		try(Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			s.delete(department);
			tx.commit();
			s.close();
		}

	}

}
