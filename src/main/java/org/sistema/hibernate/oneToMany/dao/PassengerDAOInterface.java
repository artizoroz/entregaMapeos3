package org.sistema.hibernate.oneToMany.dao;

import java.util.List;

import org.sistema.hibernate.oneToMany.models.Passenger;

/**
 * interface for BookDAO class
 * @author Eugenia Pérez
 * @email eugenia_perez@cuatrovientos.org
 */
public interface PassengerDAOInterface {
	
	public Passenger selectById(Long id);
	public List<Passenger> selectAll ();
	public void insert (Passenger book);
	public void update (Passenger book);
	public void delete (Passenger book);

}
