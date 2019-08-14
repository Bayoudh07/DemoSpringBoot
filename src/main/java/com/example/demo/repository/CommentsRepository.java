package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Comments;
import com.example.demo.entity.Pubs;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long>{
	List<Comments> findByPub(Pubs pub);

}
