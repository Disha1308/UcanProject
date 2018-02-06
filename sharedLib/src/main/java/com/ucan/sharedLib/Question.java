package com.ucan.sharedLib;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Questions")
public class Question implements Serializable {

	@Id
	@GeneratedValue
	private long id;
	private String questionText;
	private String title;
	private String preferredLanguage;
	private String preferredTime;
	private String communicationMode;
	private long upvoteCount;
	private long downvoteCount;
	   
	   @ManyToOne
		@OnDelete(action = OnDeleteAction.CASCADE)
		private User ownerUser;

		public long getUpvoteCount() {
		return upvoteCount;
	}
	public void setUpvoteCount(long upvoteCount) {
		this.upvoteCount = upvoteCount;
	}

		@ManyToMany(fetch = FetchType.EAGER)
		@Fetch(FetchMode.SELECT)
		private List<Topic> tags;

	   
		public String getPreferredLanguage() {
			return preferredLanguage;
		}
		public void setPreferredLanguage(String preferredLanguage) {
			this.preferredLanguage = preferredLanguage;
		}
		public String getPreferredTime() {
			return preferredTime;
		}
		public void setPreferredTime(String preferredTime) {
			this.preferredTime = preferredTime;
		}
		public String getCommunicationMode() {
			return communicationMode;
		}
		public void setCommunicationMode(String communicationMode) {
			this.communicationMode = communicationMode;
		}
		   
		public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public List<Topic> getTags() {
		return tags;
	}

	public void setTags(List<Topic> tags) {
		this.tags = tags;
	}

	public User getOwnerUser() {
		return ownerUser;
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

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String question) {
		this.questionText = question;
	}
	public long getDownvoteCount() {
		return downvoteCount;
	}
	public void setDownvoteCount(long downvoteCount) {
		this.downvoteCount = downvoteCount;
	}

}
