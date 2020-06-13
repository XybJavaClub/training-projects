package com.infotech.client;

import java.sql.Statement;
import java.util.Optional;

import org.hibernate.Session;

import com.infotech.entities.Book;
import com.infotech.entities.Person;
import com.infotech.util.HibernateUtil;

public class RefreshEntityClientTest2 {

	public static void main(String[] args) {
		
		cacheNClearEntity();
	}

	private static void refreshEntity() {
		try(Session session = HibernateUtil.getSessionFactory().openSession() ) {
			
			long personId = 2L;
			
			Person person = session.byId(Person.class).load(personId);
			
			//Work class is the functional interface where it has only one method
			session.doWork(connection-> {
				try (Statement statement = connection.createStatement()) {
					statement.executeUpdate("UPDATE Person SET name = UPPER(name) WHERE ID=" + personId);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			if (person != null) {
				System.out.println("BEFORE " + person.getName());
				session.refresh(person);
				System.out.println("AFTER " + person.getName());
			} else {
				System.out.println("Person not exist");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void cacheNClearEntity() {
		try(Session session = HibernateUtil.getSessionFactory().openSession() ) {
			
			long personId = 2L;
			
			Person person = session.get(Person.class, personId);
			//session.evict(person);//clear the single object
			session.clear();//clear all the session objects
			person = session.get(Person.class, personId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
