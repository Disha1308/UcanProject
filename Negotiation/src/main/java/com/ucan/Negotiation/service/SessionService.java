package com.ucan.Negotiation.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucan.Negotiation.repository.SessionRepository;
import com.ucan.sharedLib.NegotiationSession;

@Service
public class SessionService
{
	@Autowired(required = true)
	SessionRepository sRepo;
	
	public void createSession(List<NegotiationSession> sessionList) 
	{
		Iterator<NegotiationSession> sit = sessionList.iterator();
		while(sit.hasNext())
		{
			sRepo.save(sit.next());
		}
	}

	public List<NegotiationSession> getUserSession(long uid) 
	{
		List<NegotiationSession> sessions = sRepo.findByseekerId(uid);
		sessions.addAll(sRepo.findByexpertId(uid));
		return sessions;
	}
	
}