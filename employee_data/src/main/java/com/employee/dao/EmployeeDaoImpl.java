package com.employee.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.employee.entity.Employee;


@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveEmployee(Employee newEmployee) {
		// TODO Auto-generated method stub

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(newEmployee);

	}

	public Employee getById(int employeeId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Employee savedEmployee = currentSession.get(Employee.class, employeeId);
		return savedEmployee;
	}

	public Employee getByEmail(String email) {
		// TODO Auto-generated method stub

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Employee> query = currentSession.createQuery("FROM Employee e WHERE e.email =: mail", Employee.class);

		query.setParameter("mail", email);
		Employee employee = null;

		try {
			employee = (Employee) query.getResultList().get(0);
		} catch (RuntimeException re) {

			employee = null;
			re.printStackTrace();
			
		}
		return employee;
	}
	@Override
	public List<Employee> findAll() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query <Employee> query = currentSession.createQuery("From Employee", Employee.class);
		
		List<Employee> resultList = null;
		
		try {
			resultList = query.getResultList();
			
		}
		catch(RuntimeException e) {
			
		}
			return resultList;	
		
		
	}

}

