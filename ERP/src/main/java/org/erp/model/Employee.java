package org.erp.model;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Vaibhav
 *
 */
public class Employee {

	private int id;
	
	@NotEmpty(message="Please enter valid first name.")
	private String firstName;
	@NotEmpty(message="Please enter valid last name.")
	private String lastName;
	@NotEmpty(message="Please enter valid mobile number.")
	private String mobile;
	private Set<Department> departments = new HashSet<Department>();
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the departments
	 */
	public Set<Department> getDepartments() {
		return departments;
	}
	/**
	 * @param departments the departments to set
	 */
	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", mobile=" + mobile + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if ((obj instanceof Employee) && (((Employee)obj).getId()== this.id) && (((Employee)obj).getFirstName()).equalsIgnoreCase(this.firstName) && (((Employee)obj).getLastName()).equalsIgnoreCase(this.lastName)) {
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
