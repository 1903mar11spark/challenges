package com.challenge.DAO;

import java.util.List;

import com.challenge.beans.Employee;

public interface EmployeeDAO {

	public Employee getEmployeeById(int id);

	public List<Employee> getAllEmployees();

	public void addEmployee(Employee employee);

	public boolean updateEmployee(Employee employee);

	public void deleteEmployee(Employee employee);

}
