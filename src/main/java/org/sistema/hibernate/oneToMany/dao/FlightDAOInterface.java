package org.sistema.hibernate.oneToMany.dao;

import java.util.List;

import org.sistema.hibernate.oneToMany.models.Flight;

/**
 * interface for PersonDAO class
 * @author Eugenia Pérez
 * @email eugenia_perez@cuatrovientos.org
 */
public interface FlightDAOInterface {
	
	public Flight selectById(Long id);
	public List<Flight> selectAll ();
	public void insert (Flight person);
	public void update (Flight person);
	public void delete (Flight person);

}
