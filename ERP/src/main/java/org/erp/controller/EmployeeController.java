package org.erp.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.erp.model.Department;
import org.erp.model.Employee;
import org.erp.service.DepartmentService;
import org.erp.service.EmployeeService;
import org.erp.util.DepartmentEditor;
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
@RequestMapping(value="/employee")
public class EmployeeController {

	@Autowired(required=true)
	@Qualifier(value="employeeServiceImpl")
	private EmployeeService employeeService;

	@Autowired
	@Qualifier(value="departmentServiceImpl")
	private DepartmentService departmentService;
	
	@Autowired
	private DepartmentEditor departmentEditor;

	/**
	 * Method to display all employees
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/viewAll",method=RequestMethod.GET)
	public String viewAllEmployees(Model model){
		List<Employee> employees=employeeService.getAllEmployees();
		model.asMap().put("employees", employees);
		return "employee/viewEmployees";
	}
	
	/**
	 * Method to render form to add employee
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/viewAll",method=RequestMethod.POST)
	public String viewAddEmployeeForm(Model model){
		return "redirect:/employee/new";
	}


	/**
	 * Method to render form to add employee
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public String addEmployeeForm(Model model){
		Employee employee=new Employee();
		List<Department> departments=departmentService.getAllDepartments();
		model.asMap().put("departments", departments);
		model.asMap().put("employee", employee);
		return "employee/addEmployee";
	}
	
	/**
	 * Method to save new employee details
	 * @param employee
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/new",method=RequestMethod.POST)
	public String saveEmployeeDetails(@Valid Employee employee,BindingResult bindingResult,Model model) {
		
		if(bindingResult.hasErrors()){
			
			List<Department> departments=departmentService.getAllDepartments();
			model.addAttribute(departments);

			return "employee/addEmployee";
		}else{
		
			employeeService.saveEmployee(employee);
		}
		
		return "redirect:/employee/viewAll";
	}

	/**
	 * Method to render edit employee form
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/editEmployee",method=RequestMethod.GET)
	public String editEmployee(@RequestParam("id") int id,Model model){
	        Employee employee = employeeService.getEmployee(id);
			List<Department> departments=departmentService.getAllDepartments();
			model.asMap().put("departmentList", departments);
			model.asMap().put("employee", employee);
			return "employee/editEmployee";
	}

	/**
	 * Method update employee details
	 * @param employee
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/editEmployee",method=RequestMethod.POST)
	public String updateEmployeeDetails(@Valid Employee employee,BindingResult bindingResult,Model model) {
		
		if(bindingResult.hasErrors()){
			
			List<Department> departments=departmentService.getAllDepartments();
			model.asMap().put("departmentList", departments);

			return "employee/addEmployee";
		}else{
		
			employeeService.updateEmployee(employee);
		}
		
		return "redirect:/employee/viewAll";
	}

	/**
	 * Method to delete employee
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/deleteEmployee",method=RequestMethod.GET)
	public String deleteEmployee(@RequestParam("id") int id,Model model){
	        Employee employee = employeeService.getEmployee(id);
	        employeeService.deleteEmployee(employee);
			return "redirect:/employee/viewAll";
	}
	
	/**
	 * Method to render employee information
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String viewUser(@PathVariable int id, Model model) {
		
		Employee employee=employeeService.getEmployee(id);
		model.addAttribute(employee);
		return "employee/viewEmployeeDetails";
	}
	
	/**
	 * Method to view department list alloted to employee
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/viewEmployeeDepartments",method=RequestMethod.GET)
	public String viewEmployeeDepartments(@RequestParam("id") int id,Model model){
	        Employee employee = employeeService.getEmployee(id);
			model.asMap().put("employee", employee);
			return "employee/employeeDepartments";
	}


	@InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Department.class, departmentEditor);
    }
}
