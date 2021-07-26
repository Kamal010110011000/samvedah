package com.samvedah.Aalay.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
public @Data class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	
	@NotNull
	private String body;
	
	@JsonIgnore
	@OneToOne(mappedBy = "topComment")
	private Topic topic2;
	
	@NotNull
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="topic_id")
	private Topic topic;
}
