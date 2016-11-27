/**
 * 
 */
package org.sistema.hibernate.oneToMany.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sistema.hibernate.oneToMany.HibernateSession;
import org.sistema.hibernate.oneToMany.models.Flight;

/**
 * implementation of personDAOInterface
 * @author Eugenia Pérez
 * @email eugenia_perez@cuatrovientos.org
 */
public class FlightDAO implements FlightDAOInterface {

	/* 
	 * selects one person by Id
	 * @param id
	 * @return Person
	 */
	public Flight selectById(Long id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Flight person = (Flight) session.get(Flight.class, id);
	    
	    session.close();
	    return person;
	}

	/*
	 * retrieves all persons from db
	 * @return List of persons
	 */
	public List<Flight> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    List<Flight> persons = session.createQuery("from flights").list();
	    
	    session.close();
	    return persons;
	}

	/*
	 * inserts a new person in database
	 * person must come with the idcar set 
	 * @param new person
	 */
	public void insert(Flight flight) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.persist(flight);    
	    
	    session.getTransaction().commit();	         
	    session.close();

	}

	/*
	 * updates person
	 * @param person to update
	 */
	public void update(Flight flight) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();	 
		    session.beginTransaction();
		 
		    session.merge(flight); 
		    
		    session.getTransaction().commit();		 
		    session.close();
	}

	/*
	 * delete given person
	 * @param person to delete
	 */
	public void delete(Flight person) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();	    
	    session.beginTransaction();
	    
	    session.delete(person);
	 
	    session.getTransaction().commit();
	    session.close();
	}

}
