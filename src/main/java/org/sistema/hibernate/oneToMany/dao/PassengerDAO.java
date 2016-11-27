/**
 * 
 */
package org.sistema.hibernate.oneToMany.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sistema.hibernate.oneToMany.HibernateSession;
import org.sistema.hibernate.oneToMany.models.Passenger;

/**
 * implementation of BookDAOInterface
 * @author Eugenia Pérez
 * @email eugenia_perez@cuatrovientos.org
 */
public class PassengerDAO implements PassengerDAOInterface {

	/* 
	 * selects one Book by Id
	 * @param id
	 * @return Book
	 */
	public Passenger selectById(Long id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Passenger book = (Passenger) session.get(Passenger.class, id);
	    
	    session.close();
	    return book;
	}

	/*
	 * retrieves all Books from db
	 * @return List of Books
	 */
	public List<Passenger> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    List<Passenger> passengers = session.createQuery("from passengers").list();
	    
	    session.close();
	    return passengers;
	}

	/*
	 * inserts a new Book in database
	 * retrieves generated id and sets to Book instance
	 * @param new Book
	 */
	public void insert(Passenger passenger) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	
	    session.persist(passenger);
	         
	    session.getTransaction().commit();
	    session.close();

	}

	/*
	 * updates Book
	 * @param Book to update
	 */
	public void update(Passenger passenger) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();	 
		    session.beginTransaction();
		 
		    session.merge(passenger);
		 
		    session.getTransaction().commit();
		    session.close();
	}

	/*
	 * delete given Book
	 * @param Book to delete
	 */
	public void delete(Passenger passenger) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();	    
	    session.beginTransaction();
	    
	    session.delete(passenger);
	 
	    session.getTransaction().commit();
	    session.close();
	}

}
