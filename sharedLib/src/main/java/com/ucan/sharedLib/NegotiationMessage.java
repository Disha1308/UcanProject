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
@Table(name = "NegotiationMessages")
public class NegotiationMessage implements Serializable
{
	@Id
	@GeneratedValue
	private long id;
	private String messageText;
	
	boolean status;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private NegotiationSession negoSession;
	
	public NegotiationSession getNegoSession() {
		return negoSession;
	}

	public void setNegoSession(NegotiationSession negoSession) {
		this.negoSession = negoSession;
	}

	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User ownerUser;
	

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public User getOwnerUser() {
		return ownerUser;
	}

	public void setOwnerUser(User ownerUser) {
		this.ownerUser = ownerUser;
	}
	

}
