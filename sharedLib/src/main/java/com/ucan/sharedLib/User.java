package com.ucan.sharedLib;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
@Table(name = "FinalUcanUsers")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String contact;
	private String country;
	private String email;
	private String password;
	private String userName;
	private String name;
	private String communicationLang;
	private String communicationTime;
	private String communicationMode;
	

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Topic> interestedTopics;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SELECT)
	private List<Topic> expertiseTopics;

	public List<Topic> getExpertiseTopics() {
		return expertiseTopics;
	}

	public void setExpertiseTopics(List<Topic> expertiseTopics) {
		this.expertiseTopics = expertiseTopics;
	}

	public List<Topic> getIntrestedTopics() {
		return interestedTopics;
	}

	public void setIntrestedTopics(List<Topic> intrestedTopics) {
		this.interestedTopics = intrestedTopics;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCommunicationLang() {
		return communicationLang;
	}

	public void setCommunicationLang(String communicationLang) {
		this.communicationLang = communicationLang;
	}

	public String getCommunicationTime() {
		return communicationTime;
	}

	public void setCommunicationTime(String communicationTime) {
		this.communicationTime = communicationTime;
	}

	public String getCommunicationMode() {
		return communicationMode;
	}

	public void setCommunicationMode(String communicationMode) {
		this.communicationMode = communicationMode;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
}