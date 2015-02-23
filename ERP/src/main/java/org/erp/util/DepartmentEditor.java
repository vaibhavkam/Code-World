package org.erp.util;

import java.beans.PropertyEditorSupport;

import org.erp.model.Department;
import org.erp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DepartmentEditor extends PropertyEditorSupport{

	@Autowired
	@Qualifier(value="departmentServiceImpl")
	private DepartmentService departmentService;

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		Department department = departmentService.getDepartment(Integer.parseInt(text));
        setValue(department);
	}
}
