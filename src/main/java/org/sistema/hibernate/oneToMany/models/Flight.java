package org.sistema.hibernate.oneToMany.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Flight {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private Date date;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Passenger> passengers = new ArrayList<Passenger>();

	/**
	 * 
	 */
	public Flight() {
	}

	/**
	 * @param name
	 * @param date
	 */
	public Flight(String name, Date date) {
		this.name = name;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the idFlight to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passenger) {
		this.passengers = passenger;
	}

	public void addPassenger(Passenger passenger1) {
		this.passengers.add(passenger1);
		
	}

}
