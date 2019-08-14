package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Pubs;
import com.example.demo.service.ICrudService;


public class CrudController<T, ID> {

	@Autowired
	private ICrudService<T, ID> service;
	
	@GetMapping
	public List<T> getAll(){
		return service.getAll();
	}
	
	@GetMapping(value="/{email}")
	public T getById(@PathVariable String email){
		return service.getByIdEmail(email);
	}
	

	@PostMapping
	public void add(@RequestBody T entity) {
		service.add(entity);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable(value = "id")ID id,@RequestBody T entity) {
		service.update(id,entity);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable ID id) {
		service.delete(id);
	}
	
	@RequestMapping(value = "/All", method = RequestMethod.GET)
	@ResponseBody
	public Long CountAll() {
		return service.CountAll();
		
	}
	
	
}