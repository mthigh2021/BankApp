package dev.developer.repositories;

import java.util.List;

import dev.developer.models.Customer;
import dev.developer.models.Employee;

public interface GenericRepositories<T> {


	// these will be the methods that align with CRUD operations (how we interact  with the database)

	// Create
	public T add( T t);


	// read
	public T getById(Integer id);
	public List<T> getAll();
	//update
	public  boolean update(T change);
	public T registerNew(T t);

	public T loginCheck(T t);

	public T getByPassword(String p);

	public T getSpecificColumnBypassword(String p);

	// delete
	public boolean delete(T t);

	public T getByAccountID (Integer id);
  
	



}
