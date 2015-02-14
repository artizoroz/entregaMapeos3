package org.sistema.hibernate.oneToMany;

import org.hibernate.Session;
import org.sistema.hibernate.oneToMany.dao.PersonDAO;
import org.sistema.hibernate.oneToMany.models.Book;
import org.sistema.hibernate.oneToMany.models.Person;

public class Main {

	public static void main(String[] args) {
		/* Primero creamos una persona y la asociamos con dos libros */
		Book book1 = new Book();
		book1.setTitle("20000 leguas de viaje submarino");
		Book book2 = new Book();
		book2.setTitle("La maquina del tiempo");
		Person person1 = new Person();
		person1.setName("persona que se eliminara");
		person1.addBook(book1);
		person1.addBook(book2);

		/*
		 * Creamos una segunda persona, que sera eliminada, y la asociamos con
		 * otros dos libros
		 */
		Book book3 = new Book();
		book3.setTitle("El ingenioso hidalgo don Quijote de la Mancha");
		Book book4 = new Book();
		book4.setTitle("La Galatea");
		Person person2 = new Person();
		person2.setName("Alex");
		person2.addBook(book3);
		person2.addBook(book4);

		/*
		 * Guardamos las dos personas (los libros
		 * correspondientes seran guardados en cascada)
		 */
		PersonDAO personDAO = new PersonDAO();
		personDAO.insert(person1);
		personDAO.insert(person2);


		/*
		 * Eliminamos la person1 (los dos primeros libros
		 * seran borrados en cascada)
		 */
		personDAO.delete(person1);

	}

}
