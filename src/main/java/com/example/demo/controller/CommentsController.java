package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Comments;
import com.example.demo.entity.Pubs;
import com.example.demo.payload.CommentsResponse;
import com.example.demo.payload.PubsResponse;
import com.example.demo.payload.UserReponse;
import com.example.demo.service.CommentsService;

@RestController
@RequestMapping("/api/comments")
public class CommentsController extends CrudController<Comments,Long>{
	
		@Autowired
	private CommentsService commentsService;
	
	public void add(@RequestBody Comments comment) {
		String time;
    	Date date = new Date();
    	SimpleDateFormat s=new SimpleDateFormat("hh:mm - dd-MM-yyyy");
    	time =s.format(date);
    	comment.setCreatedAt(time);
       	super.add(comment);;    	
	}
	/*		
	@RequestMapping(value = "/AllCommentsByPub/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<CommentsResponse> getAllComments(@PathVariable Pubs id){
		
		List<CommentsResponse>ele= new ArrayList<CommentsResponse>();
		
		for(Comments com :super.getAllById(id)) {  
			UserReponse userRespo = new UserReponse(com.getUser().getId(),com.getUser().getEmail(),com.getUser().getFirstname(),com.getUser().getLastname(),com.getUser().getPhoto());
			CommentsResponse comment= new CommentsResponse(com.getDescription(),com.getCreatedAt(),userRespo);
			ele.add(comment);
		}
		return 	ele;
		
	}*/
	/*
	@RequestMapping(value = "/AllComm/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<CommentsResponse> getAllCommentsByPub(@PathVariable Pubs id){
		
		List<CommentsResponse>ele= new ArrayList<CommentsResponse>();
		
		for(Comments com :commentsService.getAllById(id)) {  
			UserReponse userRespo = new UserReponse(com.getUser().getId(),com.getUser().getEmail(),com.getUser().getFirstname(),com.getUser().getLastname(),com.getUser().getPhoto());
			CommentsResponse comment= new CommentsResponse(com.getDescription(),com.getCreatedAt(),userRespo);
			ele.add(comment);
		}
		return 	ele;
		
	}*/
	
	@GetMapping(value="GetAllComments")
	public List<CommentsResponse> GetAllPubs() {
		List<CommentsResponse>ele= new ArrayList<CommentsResponse>();
			
			for(Comments com :super.getAll()) {  
				UserReponse userRespo = new UserReponse(com.getUser().getId(),com.getUser().getEmail(),com.getUser().getFirstname(),com.getUser().getLastname(),com.getUser().getPhoto());
				CommentsResponse comment= new CommentsResponse(com.getId(),com.getDescription(),com.getCreatedAt(),userRespo,com.getPub().getId());
				ele.add(comment);
			
		}
			return ele;
				}
	
	@RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
	public CommentsResponse getPubByid(@PathVariable(value = "id")Long id) {
		Comments com=new Comments();
		com=commentsService.findone(id);
		UserReponse userRespo = new UserReponse();
		CommentsResponse comment= new CommentsResponse(com.getId(),com.getDescription(),com.getCreatedAt(),userRespo,com.getPub().getId());
		return comment;
	}
}
