package com.samvedah.Aalay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samvedah.Aalay.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

}
