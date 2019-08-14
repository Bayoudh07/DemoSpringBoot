package com.example.demo.payload;

import java.util.ArrayList;
import java.util.List;

public class CommentsResponse {

	private Long id;
	private String description;
	private String createdAt;
	private UserReponse user;
	//private PubsResponse pub;
	private Long idpub;
	public CommentsResponse(Long id, String description, String createdAt, UserReponse user,Long idpub) {
		super();
		this.id=id;
		this.description = description;
		this.createdAt = createdAt;
		this.user = user;
		this.idpub=idpub;
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

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

public UserReponse getUser() {
		return user;
	}

	public void setUser(UserReponse user) {
		this.user = user;
	}



	public Long getPub() {
		return idpub;
	}



	public void setPub(Long idpub) {
		this.idpub = idpub;
	}
	
	
	
}
