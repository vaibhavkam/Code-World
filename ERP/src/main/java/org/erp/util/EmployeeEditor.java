package org.erp.util;

import java.beans.PropertyEditorSupport;

import org.erp.model.Employee;
import org.erp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmployeeEditor extends PropertyEditorSupport{

	@Autowired(required=true)
	@Qualifier(value="employeeServiceImpl")
	private EmployeeService employeeService;

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		Employee employee = employeeService.getEmployee(Integer.parseInt(text));
        setValue(employee);
	}
}
