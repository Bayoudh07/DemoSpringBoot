package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Pubs;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;


@Service
@Primary
public class UserService implements ICrudService<User, Long>{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}
	

	@Override
	public User getByIdEmail(String id) {
		
		return userRepository.findByEmail(id);
	}


	@Override
	public void add(User user) {
		userRepository.save(user);
	}

	@Override
	public void update(Long id,User user) {
		userRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		User user = new User();
		user.setId(id);
		userRepository.delete(user);
	}


	@Override
	public User findone(Long id) {
		// TODO Auto-generated method stub
		return userRepository.getOne(id);
	}


	@Override
	public Long CountAll() {
		// TODO Auto-generated method stub
		return userRepository.count()-1;
	}

	

	




}
