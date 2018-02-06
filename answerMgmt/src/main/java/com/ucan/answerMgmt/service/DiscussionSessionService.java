package com.ucan.answerMgmt.service;

import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.ucan.answerMgmt.repository.DiscussionSessionRepository;
import com.ucan.sharedLib.DiscussionSession;

@Service
public class DiscussionSessionService
{
	@Autowired
	DiscussionSessionRepository sRepo;
	

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	public void createDiscussionSession(List<DiscussionSession> sessionList) 
	{
		Iterator<DiscussionSession> sit = sessionList.iterator();
		while(sit.hasNext())
		{
			sRepo.save(sit.next());
			DiscussionSession s = sRepo.findOne(sit.next().getId());
			Timer t=new Timer();
			t.schedule(new TimerTask() {
			    public void run() {
			    
			    	simpMessagingTemplate.convertAndSendToUser(s.getSeeker().getEmail(), "/queue/reply", "Session scheduled");
			    	simpMessagingTemplate.convertAndSendToUser(s.getExpert().getEmail(), "/queue/reply", "Session scheduled");
						    	
			    }
			}, s.getDiscussiontime());
		}
	}

	public List<DiscussionSession> getUserDiscussionSession(long uid) 
	{
		List<DiscussionSession> sessions = sRepo.findByseekerId(uid);
		sessions.addAll(sRepo.findByexpertId(uid));
		return sessions;
	}
	
	public void upvoteAnswer(long sId) 
	{
		DiscussionSession q = sRepo.findOne(sId);
		long upvote = q.getUpvoteCount() + 1;
		q.setUpvoteCount(upvote);
		sRepo.save(q);
	}
	
	public void downvoteAnswer(long sId) 
	{
		DiscussionSession q = sRepo.findOne(sId);
		long upvote = q.getDownvoteCount() + 1;
		q.setDownvoteCount(upvote);
		sRepo.save(q);
	}

	public List<DiscussionSession> getQuestionDiscussionSession(long qid) {
		return sRepo.findByquestionId(qid);
	}

	
}