package com.challenge.DAO;

import java.util.List;

import com.challenge.beans.Department;

public interface DepartmentDAO {

	public Department getById(int id);
	public List<Department> getAll();
	public void createDepartment(Department department);
	public void updateDepartment(Department department);
	public void deleteDepartment(Department department);
	
}
