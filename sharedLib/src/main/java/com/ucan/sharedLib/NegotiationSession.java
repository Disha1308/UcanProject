package com.ucan.sharedLib;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "NegotiationSession")
public class NegotiationSession implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	String status;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User seeker;
	

	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User expert;
	
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
	
}
