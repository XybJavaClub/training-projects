package com.infotech.client;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.infotech.entities.Book;
import com.infotech.entities.Person;
import com.infotech.util.HibernateUtil;

public class BatchInsertClientTest {

	public static void main(String[] args) {
		
		insertBatchPerson();
	}

	private static void insertBatchPerson() {
		int batchSize = 200;
		Transaction tx =null;
		try(Session session = HibernateUtil.getSessionFactory().openSession() ) {
			tx = session.beginTransaction();
			for (int i = 1; i <= 1000; i++) {
				Person person = new Person();
				person.setName("APJ_" + i);
				session.persist(person);
				if ( i > 0 && i % batchSize == 0) {
					System.out.println("flush and clear");
					session.flush();
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
