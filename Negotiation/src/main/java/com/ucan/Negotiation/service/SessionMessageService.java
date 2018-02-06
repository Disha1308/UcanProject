package com.ucan.Negotiation.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.ucan.Negotiation.repository.NegotiationMessageRepository;
import com.ucan.sharedLib.NegotiationMessage;
import com.ucan.sharedLib.User;


@Service
public class SessionMessageService 
{
	@Autowired(required = true)
	NegotiationMessageRepository messageRepo;

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	public NegotiationMessage getOneNegotiationMessage(long id) {
		try {
			NegotiationMessage u = messageRepo.findOne(id);
			System.out.println("in get one db negotiation message service");
			return u;
		} catch (Exception e) {
			return null;
		}

	}

	public void createNegotiationMessage(NegotiationMessage u) {
		System.out.println("in post db negotiation message service");
		try {
			messageRepo.save(u);
			
			u = messageRepo.findOne(u.getId());
			User sessionseeker = u.getNegoSession().getSeeker();
			User sessionexpert = u.getNegoSession().getExpert();

			if(u.getOwnerUser().getId() == sessionseeker.getId())
			{
				simpMessagingTemplate.convertAndSendToUser(sessionexpert.getEmail(), "/queue/reply", u);
			}
			else
			{
				simpMessagingTemplate.convertAndSendToUser(sessionseeker.getEmail(), "/queue/reply", u);
			}
		} catch (Exception e) 
		{
			System.out.println("error in post db negotiation message service");
		}
	}

	public List<NegotiationMessage> getSessionMessages(long sid) {
		return messageRepo.findBynegoSessionId(sid);
	}
}
