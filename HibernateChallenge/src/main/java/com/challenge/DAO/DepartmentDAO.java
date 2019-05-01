package com.challenge.DAO;

import java.util.List;

import com.challenge.beans.Department;

public interface DepartmentDAO {

	public Department getById(int id);						//works
	public List<Department> getAll();						//works
	public void createDepartment(Department department);	//works
	public void updateDepartment(Department department);	//works
	public void deleteDepartment(Department department);	//works
	
}
