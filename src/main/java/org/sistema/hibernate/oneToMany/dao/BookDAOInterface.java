package org.sistema.hibernate.oneToMany.dao;

import java.util.List;

import org.sistema.hibernate.oneToMany.models.Book;

/**
 * interface for BookDAO class
 * @author Eugenia Pérez
 * @email eugenia_perez@cuatrovientos.org
 */
public interface BookDAOInterface {
	
	public Book selectById(Long id);
	public List<Book> selectAll ();
	public void insert (Book book);
	public void update (Book book);
	public void delete (Book book);

}
