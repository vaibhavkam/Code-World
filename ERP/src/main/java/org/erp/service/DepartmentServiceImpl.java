package org.erp.service;

import java.util.List;

import org.erp.model.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private SessionFactory sessionFactory;

	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	@Transactional
	public void saveDepartment(Department department) {

		Session session = openSession();
		session.save(department);		
	}

	@Override
	@Transactional
	public void updateDepartment(Department department) {

		Session session = openSession();
		department=(Department)session.merge(department);
		session.update(department);		
	}

	@Override
	@Transactional
	public void deleteDepartment(Department department) {
		
		Session session = openSession();
		session.delete(department);		
	}

	@Override
	@Transactional
	public Department getDepartment(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Department department = (Department) session.get(Department.class,id);
		return department;
	}

	@Override
	@Transactional
	public List<Department> getAllDepartments() {

		Session session = sessionFactory.getCurrentSession();
		List<Department> departments = session.createCriteria(Department.class).list();
		return departments;

	}
}
