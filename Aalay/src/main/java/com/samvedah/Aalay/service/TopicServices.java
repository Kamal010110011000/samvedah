package com.samvedah.Aalay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samvedah.Aalay.model.Comment;
import com.samvedah.Aalay.model.Topic;
import com.samvedah.Aalay.repository.TopicRepository;

@Service
public class TopicServices {

	@Autowired
	private TopicRepository topicRepository;
	
	public Topic save(Topic topic) {
		return topicRepository.save(topic);
	}
	
	public Topic addComment(long id, Comment comment) {
		Topic fetchedTopic = topicRepository.getById(id);
		List<Comment> comments = fetchedTopic.getComments();
		comments.add(comment);
		Topic updatedTopic = fetchedTopic;
		updatedTopic.setComments(comments);
		System.out.println(updatedTopic.toString());
		return topicRepository.save(updatedTopic);
	}
	
	public List<Topic> getTopics(){
		return topicRepository.findAll();
	}
	
	
	public Topic getTopic(long id) {
		return topicRepository.getById(id);
	}
	
	public Topic updateTopic(long id, Topic topic) {
		Topic retrivedTopic = topicRepository.getById(id);
		Topic newTopic = topic;
		newTopic.setId(retrivedTopic.getId());
		return topicRepository.save(newTopic);
	}
	
	public void deleteTopic(long id) {
		topicRepository.deleteById(id);
	}
	
	
}
