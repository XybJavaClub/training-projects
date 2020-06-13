package com.infotech.client;

import java.util.Optional;

import org.hibernate.Session;

import com.infotech.entities.Book;
import com.infotech.entities.Person;
import com.infotech.util.HibernateUtil;

public class DeleteEntityClientTest {

	public static void main(String[] args) {
		
		//deletePerson();
		//getPersonByID();
		//loadPersonByID();
		//personByID();
		//bookBySimpleNaturalID();
		bookByNaturalID();
	}

	private static void deletePerson() {
		try(Session session = HibernateUtil.getSessionFactory().openSession() ) {
			
			long personId = 1L;
			
			Person person = session.get(Person.class, personId);
			if(person != null){
				session.beginTransaction();
				session.delete(person);
				session.getTransaction().commit();
			}else{
				System.out.println("Person Doesn't Exist..");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Hibernate goes to first level cache and if not available goes to DB
	 * But it not creates the proxy object
	 * EARLY LOADING
	 * */
	private static void getPersonByID() {
		try(Session session = HibernateUtil.getSessionFactory().openSession() ) {
			
			long personId = 1L;
			
			Person person = session.get(Person.class, personId);
			if (person != null) {
				System.out.println(person.getName());
			} else {
				System.out.println("Person not exist");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Throws exception if the object not available.
	 * Hibernate creates the proxy object of POJO and it will set the proxy object and sends back 
	 * Based on this proxy object it either picks from session cache or hits DB
	 * LAZY loading
	 * */
	private static void loadPersonByID() {
		try(Session session = HibernateUtil.getSessionFactory().openSession() ) {
			
			long personId = 1L;
			
			Person person = session.load(Person.class, personId);
			if (person != null) {
				System.out.println(person.getName());
			} else {
				System.out.println("Person not exist");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Similar to get method
	 * */
	private static void personByID() {
		try(Session session = HibernateUtil.getSessionFactory().openSession() ) {
			
			long personId = 1L;
			
			//Person person = session.byId(Person.class).load(personId);
			Optional<Person> optional = session.byId(Person.class).loadOptional(personId);
			if (optional.isPresent()) {
				//System.out.println(person.getName());
				System.out.println(optional.get().getName());
			} else {
				System.out.println("Person not exist");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Simple Natural ID
	 * */
	private static void bookBySimpleNaturalID() {
		try(Session session = HibernateUtil.getSessionFactory().openSession() ) {
			
			String isbn = "978-654";
			
			Book book = session.bySimpleNaturalId(Book.class).getReference(isbn);
			if (book != null) {
				System.out.println(book.getTitle() + " BY "+ book.getAuthor().getName());
			} else {
				System.out.println("Book not exist");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Natural ID
	 * */
	private static void bookByNaturalID() {
		try(Session session = HibernateUtil.getSessionFactory().openSession() ) {
			
			String isbn = "978-654";
			
			/*
			Book book = session.byNaturalId(Book.class).using("isbn", isbn).load();
			if (book != null) {
				System.out.println(book.getTitle() + " BY "+ book.getAuthor().getName());
			} else {
				System.out.println("Person not exist");
			}
			*/
			
			Optional<Book> optional = session.byNaturalId(Book.class).using("isbn", isbn).loadOptional();
			if (optional.isPresent()) {
				System.out.println(optional.get().getTitle());
			} else {
				System.out.println("Book not exist");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
