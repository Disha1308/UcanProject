package com.ucan.sharedLib;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Answers")
public class Answer implements Serializable
{
	@Id
	@GeneratedValue
	private long id;
	private String description;

	boolean status;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Question question;

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

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
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
	
	
	
}
