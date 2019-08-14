package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Comments implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	 
	    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false)
	    @JoinColumn(name = "user_id")
	    @JsonIgnore
	    private User user;

	   
	    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false)
	    @JoinColumn(name = "pub_id")
	    @JsonIgnore
	    private Pubs pub;
	
	@NotBlank
	private String description;
	
	private String createdAt;

	private transient Long userId;
	private transient Long pubId;
	
	
	
	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comments(User user, Pubs pub,@NotBlank String description, String createdAt) {
		super();
		this.user = user;
		this.pub = pub;
		this.description = description;
		this.createdAt = createdAt;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Pubs getPub() {
		return pub;
	}

	public void setPub(Pubs pub) {
		this.pub = pub;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getPubId() {
		return pubId;
	}

	public void setPubId(Long pubId) {
		this.pubId = pubId;
	}

	
	
}
