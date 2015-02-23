package org.erp.service;

import java.util.List;

import org.erp.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private SessionFactory sessionFactory;

	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {

		Session session = openSession();
		session.save(employee);
	}

	@Override
	@Transactional
	public void updateEmployee(Employee employee) {

		Session session = openSession();
		employee=(Employee)session.merge(employee);
		session.update(employee);
	}

	@Override
	@Transactional
	public void deleteEmployee(Employee employee) {
		
		Session session = sessionFactory.getCurrentSession();
		session.delete(employee);
	}

	@Override
	@Transactional
	public Employee getEmployee(int id) {

		Session session = sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.get(Employee.class,id);
		return employee;
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {

		Session session = sessionFactory.getCurrentSession();
		List<Employee> employees = session.createCriteria(Employee.class).list();
		return employees;

	}

}
