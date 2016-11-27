package org.sistema.hibernate.oneToMany;

import org.hibernate.Session;
import org.sistema.hibernate.oneToMany.dao.FlightDAO;
import org.sistema.hibernate.oneToMany.models.Passenger;
import org.sistema.hibernate.oneToMany.models.Flight;

public class Main {

	public static void main(String[] args) {
		/* Primero creamos una persona y la asociamos con dos libros */
		Passenger passenger1 = new Passenger();
		passenger1.setName("passenger 1");
		Passenger passenger2 = new Passenger();
		passenger2.setName("passenger 2");
		Flight flight1 = new Flight();
		flight1.setName("flight 1");
		flight1.addPassenger(passenger1);
		flight1.addPassenger(passenger2);

		/*
		 * Creamos una segunda persona, que sera eliminada, y la asociamos con
		 * otros dos libros
		 */
		Passenger passenger3 = new Passenger();
		passenger3.setName("passenger 3");
		Passenger passenger4 = new Passenger();
		passenger4.setName("passenger 4");
		Flight flight2 = new Flight();
		flight2.setName("flight 2");
		flight2.addPassenger(passenger3);
		flight2.addPassenger(passenger4);

		/*
		 * Guardamos las dos personas (los libros
		 * correspondientes seran guardados en cascada)
		 */
		FlightDAO flightDAO = new FlightDAO();
		flightDAO.insert(flight1);
		flightDAO.insert(flight2);


		/*
		 * Eliminamos la person1 (los dos primeros libros
		 * seran borrados en cascada)
		 */
		flightDAO.delete(flight1);

	}

}
