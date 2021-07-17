package com.samvedah.Aalay.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samvedah.Aalay.model.Comment;
import com.samvedah.Aalay.model.Topic;
import com.samvedah.Aalay.service.TopicServices;

@RestController()
@RequestMapping("/api/topic")
public class TopicController {
	
	@Autowired
	private TopicServices topicServices;
	
	@PostMapping()
	public ResponseEntity<Topic> createTopic(@RequestBody Topic topic){
		System.out.println("creating topic >>>>>>>>>>>>>");
		Topic savedTopic = topicServices.save(topic);
		return ResponseEntity.accepted().body(savedTopic);
	}
	
	@GetMapping()
	public ResponseEntity<List<Topic>> getAllTopics(){
		System.out.println("Getting all topics");
		ArrayList<Topic> topics =(ArrayList<Topic>) topicServices.getTopics(); 
		return ResponseEntity.ok().body(topics);
	}
	
	@PatchMapping()
	public ResponseEntity<Topic> addComment(@RequestParam Long id, @RequestBody Comment comment){
		System.out.println("adding comment");
		Topic savedTopic = topicServices.addComment(id, comment);
		return ResponseEntity.ok(savedTopic);
	}
	
	
	

}
