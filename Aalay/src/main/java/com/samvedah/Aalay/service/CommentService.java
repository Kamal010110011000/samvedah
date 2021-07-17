package com.samvedah.Aalay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samvedah.Aalay.model.Comment;
import com.samvedah.Aalay.model.Topic;
import com.samvedah.Aalay.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private TopicServices topicServices;
	
	public Comment save(Comment comment, long topic_id) {
		Topic topic = topicServices.getTopic(topic_id);
		comment.setTopic(topic);
		return commentRepository.save(comment);
	}
	
	public List<Comment> getComments() {
		return commentRepository.findAll();
	}
}
