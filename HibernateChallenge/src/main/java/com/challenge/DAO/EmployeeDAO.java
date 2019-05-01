package com.challenge.DAO;

import java.util.List;

import com.challenge.beans.Department;
import com.challenge.beans.Employee;

public interface EmployeeDAO {
	
	public Employee getById(int id);								//works
	public List<Employee> getByDepartment(Department department);	//works
	public void createEmployee(Employee employee);					//works
	public void updateEmployee(Employee employee);					//works
	public void deleteEmployee(Employee employee);					//works

}
