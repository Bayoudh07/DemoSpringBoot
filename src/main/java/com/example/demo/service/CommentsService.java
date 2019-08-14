package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Comments;
import com.example.demo.entity.Pubs;
import com.example.demo.repository.CommentsRepository;
import com.example.demo.repository.PubsRepository;
import com.example.demo.repository.UserRepository;

@Service
@Primary
public class CommentsService implements ICrudService<Comments,Long>{
	
	@Autowired
	private CommentsRepository commentRepository;
	@Autowired
	private PubsRepository pubsRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<Comments> getAll() {
		
		return commentRepository.findAll();
	}

	@Override
	public Comments getByIdEmail(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Comments comment) {
		comment.setPub(pubsRepository.getOne(comment.getPubId()));
		comment.setUser(userRepository.getOne(comment.getUserId()));
		commentRepository.save(comment);
	}

	@Override
	public void update(Long id,Comments comment) {
		Comments comments = commentRepository.getOne(id);
		if(comment.getDescription().isEmpty()) {
			comments.setDescription(comments.getDescription());
		}else {
			comments.setDescription(comment.getDescription());
			
		}
		String time;
    	Date date = new Date();
    	SimpleDateFormat s=new SimpleDateFormat("hh:mm - dd-MM-yyyy");
    	time =s.format(date);
    	comments.setCreatedAt(time);
    	commentRepository.save(comments);
	}

	@Override
	public void delete(Long id) {
		Comments com = new Comments();
		com.setId(id);
		commentRepository.delete(com);
		
	}

	@Override
	public Comments findone(Long id) {
		// TODO Auto-generated method stub
		return commentRepository.getOne(id);
	}

	


	public List<Comments> findAllByPub(Pubs pub){
		return commentRepository.findByPub(pub);
		
	}

	@Override
	public Long CountAll() {
		// TODO Auto-generated method stub
		return commentRepository.count();
	}

	



}
