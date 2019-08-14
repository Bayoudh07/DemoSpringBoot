package com.example.demo.payload;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.example.demo.entity.Comments;



public class PubsResponse {
	private Long id;
	
	private String description;
	
	private String position;
	
	private String createdAt;
	
	private boolean enable;
	
    private byte[] photo;
	private  UserReponse userId;
	//private List<Comments>comment= new ArrayList<Comments>();
	
	public PubsResponse(Long id, String description, String position, String createdAt,boolean enable, byte[] photo,
			UserReponse userId) {
		super();
		this.id = id;
		this.description = description;
		this.position = position;
		this.createdAt = createdAt;
		this.enable=enable;
		this.photo = photo;
		this.userId = userId;
		//this.comment = comment;
	}
	public PubsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public UserReponse getUserId() {
		return userId;
	}
	public void setUserId(UserReponse userId) {
		this.userId = userId;
	}

	
	
	
	

}
