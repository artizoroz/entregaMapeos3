/**
 * 
 */
package org.sistema.hibernate.oneToMany.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sistema.hibernate.oneToMany.HibernateSession;
import org.sistema.hibernate.oneToMany.models.Book;

/**
 * implementation of BookDAOInterface
 * @author Eugenia Pérez
 * @email eugenia_perez@cuatrovientos.org
 */
public class BookDAO implements BookDAOInterface {

	/* 
	 * selects one Book by Id
	 * @param id
	 * @return Book
	 */
	public Book selectById(Long id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Book book = (Book) session.get(Book.class, id);
	    
	    session.close();
	    return book;
	}

	/*
	 * retrieves all Books from db
	 * @return List of Books
	 */
	public List<Book> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    List<Book> bookes = session.createQuery("from Book").list();
	    
	    session.close();
	    return bookes;
	}

	/*
	 * inserts a new Book in database
	 * retrieves generated id and sets to Book instance
	 * @param new Book
	 */
	public void insert(Book book) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	
	    session.persist(book);
	         
	    session.getTransaction().commit();
	    session.close();

	}

	/*
	 * updates Book
	 * @param Book to update
	 */
	public void update(Book book) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();	 
		    session.beginTransaction();
		 
		    session.merge(book);
		 
		    session.getTransaction().commit();
		    session.close();
	}

	/*
	 * delete given Book
	 * @param Book to delete
	 */
	public void delete(Book book) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();	    
	    session.beginTransaction();
	    
	    session.delete(book);
	 
	    session.getTransaction().commit();
	    session.close();
	}

}
