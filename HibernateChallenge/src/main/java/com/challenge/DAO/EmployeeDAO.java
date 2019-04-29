package com.challenge.DAO;

import java.util.List;

import com.challenge.beans.Department;
import com.challenge.beans.Employee;

public interface EmployeeDAO {
	
	public Employee getById(int id);
	public List<Employee> getByDepartment(Department department);
	public void createEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(Employee employee);

}
