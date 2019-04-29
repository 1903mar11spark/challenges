package com.challenge.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import com.challenge.beans.Department;

import com.revature.util.ConnectionUtil;

public class DepartmentDAOImpl {
	
	SessionFactory sf = ConnectionUtil.getSessionFactory();
	
	public Department getById(int id) {
		Session s = sf.openSession();
		Department dep = new Department();
		dep = s.get(Department.class, id);
		s.close();
		return dep;
	}
	
	public List<Department> getAll(){
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
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.update(department);
		tx.commit();
		s.close();
	}
	
	public void deleteDepartment(Department department) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.delete(department);
		tx.commit();
		s.close();
	}

}
