package com.client;

import org.hibernate.Session;

import com.dataObjects.Employee;
import com.dataServices.DatabaseUtil;

public class DirtyCheckingClientTest {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = DatabaseUtil.getSessionFactory().openSession();
			Employee employee = session.get(Employee.class, 8);
			if(employee != null){
				session.beginTransaction();
				employee.setSalary(40000.00);
				employee.setEmployeeName("Martin Binge");//this will update automatically if it changed
				//session.update(employee);//Even though you comment this line still 
                                // hibernate triggers update query if employee salary or name different 
                                //in the database this feature is called dirty checking in hibernate

				session.getTransaction().commit();
				//employee.setEmployeeName("Martin Bingel2");
			}else{
				System.out.println("Employee doesn't exist with provided Id..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null){
				session.close();
			}
		}

	}

}
