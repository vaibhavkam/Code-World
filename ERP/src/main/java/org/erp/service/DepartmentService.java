package org.erp.service;

import java.util.List;

import org.erp.model.Department;


/**
 * @author Vaibhav
 *
 */
public interface DepartmentService {

	public void saveDepartment(Department department);
	
	public void updateDepartment(Department department);
	
	public void deleteDepartment(Department department);
	
	public Department getDepartment(int id);
	
	public List<Department> getAllDepartments();


}
