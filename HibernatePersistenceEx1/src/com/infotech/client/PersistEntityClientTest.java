package com.infotech.client;

import org.hibernate.Session;

import com.infotech.entities.Book;
import com.infotech.entities.Person;
import com.infotech.util.HibernateUtil;

public class PersistEntityClientTest {

	public static void main(String[] args) {
		
		try(Session session = HibernateUtil.getSessionFactory().openSession() ) {
			
			Person author1 = new Person();
			author1.setName("Newton George");
			//author1.setId(2L);
			
			Book book1 = new Book();
			book1.setIsbn("978-654");
			book1.setTitle("SQL Uses");
			book1.setAuthor(author1);
			
			Book book2 = new Book();
			book2.setIsbn("900-312");
			book2.setTitle("SQL Uses Contexts");
			book2.setAuthor(author1);
			
			author1.getBooks().add(book1);
			author1.getBooks().add(book2);
			
			session.beginTransaction();
			//session.save(author1);
			session.persist(author1);
			//session.saveOrUpdate(author1);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
