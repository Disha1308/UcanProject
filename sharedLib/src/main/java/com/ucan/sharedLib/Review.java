package com.ucan.sharedLib;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Entity
@Table(name="Review")
public class Review implements Serializable
{
	@Id
	@GeneratedValue
    private long id;
	@Lob
	@Type(type = "org.hibernate.type.TextType")
    private String reviewText;
   
    @ManyToOne
    private Answer ownerAnswer;
        
    @ManyToOne
    private User ownerUser;
    
	public User getOwnerUser() {
		return ownerUser;
	}
	public void setOwnerUser(User ownerUser) {
		this.ownerUser = ownerUser;
	}
	public Answer getOwnerAnswer() {
		return ownerAnswer;
	}
	public void setOwnerAnswer(Answer ownerAnswer) {
		this.ownerAnswer = ownerAnswer;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
}
