package com.ucan.sharedLib;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "DiscussionSession")
public class DiscussionSession implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	String status;
	Timestamp discussiontime;
	private long upvoteCount;
	private long downvoteCount;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User seeker;
	

	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User expert;

	@OneToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Question question;
	
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
	public Timestamp getDiscussiontime() {
		return discussiontime;
	}

	public void setDiscussiontime(Timestamp discussiontime) {
		this.discussiontime = discussiontime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getSeeker() {
		return seeker;
	}

	public void setSeeker(User seeker) {
		this.seeker = seeker;
	}

	public User getExpert() {
		return expert;
	}

	public void setExpert(User expert) {
		this.expert = expert;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
}
