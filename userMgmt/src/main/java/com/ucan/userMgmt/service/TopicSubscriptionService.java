package com.ucan.userMgmt.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucan.sharedLib.Topic;
import com.ucan.sharedLib.User;
import com.ucan.userMgmt.repository.UserRepository;

@Service
public class TopicSubscriptionService {

	@Autowired
	UserRepository userRepo;
	

	public static Predicate<Topic> isid(long id) {
		return p -> p.getId() == id;
	}

	public void UnsubscribeInterestedTopic(long userid, long topicid) {
		User u = userRepo.findOne(userid);

		List<Topic> topics = u.getIntrestedTopics();
		topics.removeIf(isid(topicid));

		u.setIntrestedTopics(topics);
		userRepo.save(u);
	}
	
	public void UnsubscribeExpertiseTopic(long userid, long topicid) {
		User u = userRepo.findOne(userid);

		List<Topic> topics = u.getExpertiseTopics();
		topics.removeIf(isid(topicid));

		u.setExpertiseTopics(topics);
		userRepo.save(u);
	}

	public List<Topic> getAllInterestedTopics(long userId) {
		return userRepo.findOne(userId).getIntrestedTopics();
	}
	
	public List<Topic> getAllExpertiseTopics(long userId) {
		return userRepo.findOne(userId).getExpertiseTopics();
	}

	public List<User> getAllExperts(List<Topic> topicId) {		
		List<User> uList = new ArrayList<User>();
		Iterator<Topic> tIterator = topicId.iterator();
		while (tIterator.hasNext())
		{
			uList.addAll(userRepo.findByexpertiseTopics(tIterator.next()));
		}
		return uList;
	}
	
	public List<User> getAllFollowers(List<Topic> topicId) {		
		List<User> uList = new ArrayList<User>();
		Iterator<Topic> tIterator = topicId.iterator();
		while (tIterator.hasNext())
		{
			uList.addAll(userRepo.findByinterestedTopics(tIterator.next()));
		}
		return uList;
	}
	
	public void subscribeInterestedTopics(long uId, List<Topic> tList) 
	{
		User  u = userRepo.findOne(uId);
		List<Topic> t = u.getIntrestedTopics();
		t.addAll(tList);
		u.setIntrestedTopics(t);
		userRepo.save(u);		
	}
	
	public void subscribeExpertiseTopics(long uId, List<Topic> tList) 
	{
		User  u = userRepo.findOne(uId);
		List<Topic> t = u.getExpertiseTopics();
		t.addAll(tList);
		u.setExpertiseTopics(t);
		userRepo.save(u);		
	}

}
