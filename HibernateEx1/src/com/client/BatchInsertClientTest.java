package com.client;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dataObjects.Employee;
import com.dataServices.DatabaseUtil;

public class BatchInsertClientTest {

	public static void main(String[] args) {
		
		insertBatchEmployee();
	}

	private static void insertBatchEmployee() {
		int batchSize = 5;
		Transaction tx =null;
		try(Session session = DatabaseUtil.getSessionFactory().openSession() ) {
			tx = session.beginTransaction();
			for (int i = 1; i <= 10; i++) {
				Employee employee = new Employee();
				employee.setEmployeeName("Batch updated " + i);
				session.persist(employee);
				if ( i > 0 && i % batchSize == 0) {
					System.out.println("flush and clear");
					session.flush();//commit the records
					session.clear();
				}
			}
			tx.commit();
			
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
	
}
