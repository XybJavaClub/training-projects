package com.infotech.client;

import java.util.Optional;

import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import com.infotech.entities.Book;
import com.infotech.entities.Person;
import com.infotech.util.HibernateUtil;

public class BatchUpdateStatelessClientTest {

	public static void main(String[] args) {
		
		updateBatchPerson();
	}

	private static void updateBatchPerson() {
		/*Always hit to Database to get the records*/
		StatelessSession statelessSession = null;
		Transaction tx =null;
		ScrollableResults scrollableResults = null;
		try {
			statelessSession = HibernateUtil.getSessionFactory().openStatelessSession(); 
			tx = statelessSession.beginTransaction();
			scrollableResults = statelessSession.createQuery("select p from Person p").scroll(ScrollMode.FORWARD_ONLY);
			while (scrollableResults.next()) {
				Person person = (Person)scrollableResults.get(0);
				person.setName(person.getName()+ "-updated");
				statelessSession.update(person);
			}
			
			tx.commit();
			
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			scrollableResults.close();
			statelessSession.close();
		}
	}
	
}
