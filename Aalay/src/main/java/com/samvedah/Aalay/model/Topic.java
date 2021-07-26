package com.samvedah.Aalay.model;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.samvedah.Aalay.utilites.Tags;

import lombok.Data;

@Entity
public @Data class Topic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull(message = "Title can't be null")
	private String title;
	
	@NotNull(message = "Provide appropriate tag")
	private Tags tag;
	

	private String detail;
	

	private long likeCount = 0; 
	

	private long disLikeCount = 0;
	

	private long shareCount = 0;
	
	
	private long contributionCount = 0;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "column_id", referencedColumnName= "id")
	private Comment topComment;
	
	@OneToMany(mappedBy = "topic", fetch = FetchType.LAZY)
	private List<Comment> comments;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDateTime = Date.from(Instant.now());

}
