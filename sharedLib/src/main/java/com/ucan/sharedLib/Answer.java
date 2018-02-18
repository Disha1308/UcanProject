package com.ucan.sharedLib;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "Answers")
public class Answer implements Serializable
{
	@Id
	@GeneratedValue
	private long id;
	
	private long upvoteCount;
	private long downvoteCount;
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	private String description;
	private boolean status;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Question ownerQuestion;

	public Question getOwnerQuestion() {
		return ownerQuestion;
	}

	public void setOwnerQuestion(Question ownerquestion) {
		this.ownerQuestion = ownerquestion;
	}

	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User ownerUser;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private DiscussionSession session;
	
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public User getOwnerUser() {
		return ownerUser;
	}
	
	public DiscussionSession getSession() {
		return session;
	}

	public void setSession(DiscussionSession session) {
		this.session = session;
	}

	public void setOwnerUser(User ownerUser) {
		this.ownerUser = ownerUser;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public long getUpvoteCount() {
		return upvoteCount;
	}

	public void setUpvoteCount(long upvoteCount) {
		this.upvoteCount = upvoteCount;
	}

	public long getDownvoteCount() {
		return downvoteCount;
	}

	public void setDownvoteCount(long downvoteCount) {
		this.downvoteCount = downvoteCount;
	}


	
	
	
}
