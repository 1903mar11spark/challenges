package com.challenge.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.challenge.beans.Department;
import com.challenge.util.ConnectionUtil;

public class DepDAOImpl implements DepartmentDAO{

	SessionFactory sf = ConnectionUtil.getSessionFactory();
	
	@Override
	public List<Department> getAll() 
	{
		List<Department> list = new ArrayList<Department>();
		Session s = sf.openSession();
			Transaction tx = s.beginTransaction();
			String hql = "FROM DEPARTMENT";
			Query q = s.createQuery(hql);
			
			tx.commit();
			s.close();
			
		return (List<Department>) q;
		
	}
	
	
	
	@Override
	public Department getById(int id) 
	{
		Department x =null;
		Session s = sf.openSession();
			Transaction tx = s.beginTransaction();
			x =s.get(Department.class, id);
			tx.commit();
		
		return x;
	}

	@Override
	public void createDepartment(Department department) 
	{
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.save(department);
	
		tx.commit();
		s.close();
		
	}

	@Override
	public void updateDepartment(Department department) 
	{
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.update(department);
	
		tx.commit();
		s.close();
	}

	
	@Override
	public void deleteDepartment(Department department) 
	{
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.delete(department);
	
		tx.commit();
		s.close();
	}

}

