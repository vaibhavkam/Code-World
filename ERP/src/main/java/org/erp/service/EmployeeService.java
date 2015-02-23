package org.erp.service;

import java.util.List;

import org.erp.model.Employee;

public interface EmployeeService {

	public void saveEmployee(Employee employee);
	
	public void updateEmployee(Employee employee);
	
	public void deleteEmployee(Employee employee);
	
	public Employee getEmployee(int id);
	
	public List<Employee> getAllEmployees();

}
