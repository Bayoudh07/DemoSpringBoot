package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Pubs;
import com.example.demo.repository.PubsRepository;
import com.example.demo.repository.UserRepository;

@Service
@Primary
public class PubsService implements ICrudService<Pubs,Long>{

	@Autowired
	private PubsRepository pubsRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Pubs> getAll() {

		return pubsRepository.findAll();
	}

	@Override
	public Pubs getByIdEmail(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Pubs pub) {
		pub.setUser(userRepository.getOne(pub.getUserId()));
		pubsRepository.save(pub);
		
	}

	@Override
	public void update(Long id,Pubs pu) {
		Pubs pub=pubsRepository.getOne(id);
		if(pu.getDescription().isEmpty()) {
			pub.setDescription(pub.getDescription());
		}else {
			pub.setDescription(pu.getDescription());
		}
		if(pu.getPosition().isEmpty()) {
			pub.setPosition(pub.getPosition());
		}else {
			pub.setPosition(pu.getPosition());
		}
		if(pu.getPhoto()==null) {
			pub.setPhoto(pub.getPhoto());
		}else {
		pub.setPhoto(pu.getPhoto());
		}
		String time;
    	Date date = new Date();
    	SimpleDateFormat s=new SimpleDateFormat("hh:mm - dd-MM-yyyy");
    	time =s.format(date);
    	pub.setCreatedAt(time);
		pubsRepository.save(pub);
	}

	@Override
	public void delete(Long id) {
		Pubs pub = new Pubs();
		pub.setId(id);
		pubsRepository.delete(pub);
		
	}

	@Override
	public Pubs findone(Long id) {
		// TODO Auto-generated method stub
		return pubsRepository.getOne(id);
	}

	@Override
	public Long CountAll() {
		// TODO Auto-generated method stub
		return pubsRepository.count();
	}



	public void updateStatus(Long id) {
		Pubs pub=pubsRepository.getOne(id);
		pub.setEnable(true);
		pubsRepository.save(pub);
	}



}
