package com.dataServices;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.dataObjects.Employee;

public class EmployeeDao {
	
	public void addEmployee(Employee employee) {
		 //The try-with-resources Statement doesn't to close, it closes automatically
		//add in java 1.7
		try (Session session = DatabaseUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			//till this object in Transient
			Integer id =(Integer)session.save(employee);
			//now it is in Persistent
			System.out.println("Employee is created  with Id::"+id);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	
	public void persistEmployee(Employee employee) {
		 //The try-with-resources Statement doesn't to close, it closes automatically
		//add in java 1.7
		try (Session session = DatabaseUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.persist(employee);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
 
	public void addOrUpdateEmployee(Employee employee) {
		 //The try-with-resources Statement doesn't to close, it closes automatically
		//add in java 1.7
		try (Session session = DatabaseUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.saveOrUpdate(employee);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	
	public Employee fetchEmployeebyId(int employeeId) {
		Employee employee = null;
		try (Session session = DatabaseUtil.getSessionFactory().openSession()) {
 
			 employee = session.get(Employee.class,employeeId );
			if(employee != null){
				return employee;
			}else{
				System.out.println("Employee doesn't exist with provideded Id..");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}
 
	
	public void updateEmployeeById(int employeeId, Double newSal) {
		try (Session session = DatabaseUtil.getSessionFactory().openSession()) {
 
			Employee employee = session.get(Employee.class, employeeId);
			if(employee != null){
				employee.setSalary(newSal);
				session.beginTransaction();
				session.update(employee);
				session.getTransaction().commit();
			}else{
				System.out.println("Employee doesn't exist with provideded Id..");
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
 
	
	public void deleteEmployeeById(Integer employeeId) {
 
		try (Session session = DatabaseUtil.getSessionFactory().openSession()) {
			Employee employee = session.get(Employee.class, employeeId);
			if(employee != null){
				session.beginTransaction();
				
				session.delete(employee);
				session.getTransaction().commit();
			}else{
				System.out.println("Employee doesn't exist with provideded Id..");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	
	}
}
