package org.erp.model;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Vaibhav
 *
 */
public class Department {

	private int id;
	@NotEmpty(message="Please enter valid name.")
	private String name;
	
	@NotEmpty(message="Please enter valid unit name.")
	private String businessUnit;
	
	@NotEmpty(message="Please enter work description.")
	private String description;

	
	private Set<Employee> employees = new HashSet<Employee>();
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the businessUnit
	 */
	public String getBusinessUnit() {
		return businessUnit;
	}
	/**
	 * @param businessUnit the businessUnit to set
	 */
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the employees
	 */
	public Set<Employee> getEmployees() {
		return employees;
	}
	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if ((obj instanceof Department) && (((Department)obj).getId()== this.id) && (((Department)obj).getName()== this.name)) {
			return true;
		} else {
			return false;		
		}
	}
	
	@Override
	public int hashCode() {
        return new Long(id).hashCode();	   
	}
}
