package org.sistema.hibernate.oneToMany.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPassenger;
	private String name;
	private String phone;
	
	

	/**
	 * 
	 */
	public Passenger() {
	}

	/**
	 * @param name
	 * @param phone
	 */
	public Passenger(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public long getIdPassenger() {
		return idPassenger;
	}

	public void setIdPassenger(long idPassenger) {
		this.idPassenger = idPassenger;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
