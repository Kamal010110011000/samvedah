package com.samvedah.Aalay.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samvedah.Aalay.model.Comment;
import com.samvedah.Aalay.service.CommentService;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping()
	public ResponseEntity<Comment> createComment(@RequestBody Comment comment,@RequestParam String topic_id){
		Comment savedComment = commentService.save(comment, Long.parseLong(topic_id));
		return ResponseEntity.accepted().body(savedComment);
	}
	
	@GetMapping()
	public ResponseEntity<List<Comment>> getComments(){
		ArrayList<Comment> comments = (ArrayList<Comment>) commentService.getComments();
		return ResponseEntity.accepted().body(comments);
	}
}
