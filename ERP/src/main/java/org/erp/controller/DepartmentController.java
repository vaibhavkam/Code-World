package org.erp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.erp.model.Department;
import org.erp.model.Employee;
import org.erp.service.DepartmentService;
import org.erp.service.EmployeeService;
import org.erp.util.EmployeeEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author Vaibhav
 *
 */
@Controller
@RequestMapping(value="/department")
public class DepartmentController {

	@Autowired(required=true)
	@Qualifier(value="departmentServiceImpl")
	private DepartmentService departmentService;
	
	@Autowired(required=true)
	@Qualifier(value="employeeServiceImpl")
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeEditor employeeEditor; 

	/**
	 * Method to display all departments
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/viewAll",method=RequestMethod.GET)
	public String viewAllDepartments(Model model){
		List<Department> departments=departmentService.getAllDepartments();
		model.asMap().put("departments", departments);
		return "department/viewDepartments";
	}

	/**
	 * Method to render add department form
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/viewAll",method=RequestMethod.POST)
	public String viewAddDepartmentForm(Model model){
		return "redirect:/department/new";
	}


	/**
	 * Method to render add department form
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public String addDepartmentForm(Model model){
		Department department=new Department();
		List<Employee> employees=employeeService.getAllEmployees();
		model.asMap().put("department", department);
		model.asMap().put("employees", employees);
		return "department/addDepartment";
	}
	
	/**
	 * Method to save new department details
	 * @param department
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/new",method=RequestMethod.POST)
	public String saveDepartmentDetails(@Valid Department department,BindingResult bindingResult,Model model) {
		
		if(bindingResult.hasErrors()){
			
			List<Employee> employees=employeeService.getAllEmployees();
			model.asMap().put("employees", employees);

			return "department/addDepartment";
		}else{
		
			departmentService.saveDepartment(department);
		}
		
		return "redirect:/department/viewAll";
	}
	
	/**
	 * Method to render edit department form
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/editDepartment",method=RequestMethod.GET)
	public String editDepartment(@RequestParam("id") int id,Model model){
			Department department = departmentService.getDepartment(id);
			List<Employee> employees=employeeService.getAllEmployees();
			model.asMap().put("employeeList", employees);
			model.asMap().put("department", department);
			return "department/editDepartment";
	}

	/**
	 * Method update department details
	 * @param department
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/editDepartment",method=RequestMethod.POST)
	public String updateDepartmentDetails(@Valid Department department,BindingResult bindingResult,Model model) {
		
		if(bindingResult.hasErrors()){
			
			List<Employee> employees=employeeService.getAllEmployees();
			model.asMap().put("employeeList", employees);

			return "department/addDepartment";
		}else{
		
			departmentService.updateDepartment(department);
		}
		
		return "redirect:/department/viewAll";
	}

		
	/**
	 * Method to delete department
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/deleteDepartment",method=RequestMethod.GET)
	public String deleteDepartment(@RequestParam("id") int id,Model model){
			Department department = departmentService.getDepartment(id);
			departmentService.deleteDepartment(department);
			return "redirect:/department/viewAll";
	}

	/**
	 * Method to render department information
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String viewDepartment(@PathVariable int id, Model model) {
		
		Department department=departmentService.getDepartment(id);
		model.addAttribute(department);
		return "department/viewDepartmentDetails";
	}
	
	/**
	 * Method to view employees list alloted to department
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/viewDepartmentEmployees",method=RequestMethod.GET)
	public String viewDepartmentEmployees(@RequestParam("id") int id,Model model){
	        Department department = departmentService.getDepartment(id);
			model.asMap().put("department", department);
			return "department/departmentEmployees";
	}

	@InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Employee.class, employeeEditor);
    }

}
