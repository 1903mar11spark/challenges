package com.challenge.DAO;

import java.util.List;

import com.challenge.beans.Department;

public interface DepartmentDAO {

	public Department getDepartmentById(int id); 
	
	public List<Department> getAllDepartments(); 
	
	public void addDepartment(Department department); 
	
	public void updateDepartment(Department department); 
	
	public void deleteDepartment(Department department); 
}
