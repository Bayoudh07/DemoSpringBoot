package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Pubs;


public interface ICrudService<T, ID>{
	
	List<T> getAll();
	
	 T getByIdEmail(String id);
	 	
	void add(T entity);
	
	void update(ID id,T entity);
	
	void delete(ID id);
	
	T findone(ID id);
	
	Long CountAll();

}
