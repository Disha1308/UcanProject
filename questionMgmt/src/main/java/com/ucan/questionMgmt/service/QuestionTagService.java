package com.ucan.questionMgmt.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ucan.questionMgmt.repository.QuestionRepository;
import com.ucan.sharedLib.Question;
import com.ucan.sharedLib.Topic;
import com.ucan.sharedLib.User;



@Service
public class QuestionTagService {
	
	@Autowired
	QuestionRepository qRepo;
	
	
	public static Predicate<Topic> isid(long id) {
		return p -> p.getId() == id;
	}


	public List<Topic> getTags(long qId) 
	{
		return qRepo.findOne(qId).getTags(); 
		
	}

	
	public Question editTagService(long qId, List<Topic> newTList) 
	{
		Question q =qRepo.findOne(qId);
		q.setTags(newTList);
		qRepo.save(q);
		return q;
	}
	
	
	public List<Question> getQuestionsService(List<Topic> topicId) {
		
		List<Question> qList = new ArrayList<Question>();
		Iterator<Topic> tIterator = topicId.iterator();
		while (tIterator.hasNext())
		{
			
			qList.addAll(qRepo.findBytags(tIterator.next()));
		}
		return qList;
	}


	public List<Question> getInterestedTopicQuestions(long uid) {
		//here there is dependency created for userManagement module.
		//This dependency can be removed by using the restTemplate
		RestTemplate restT = new RestTemplate();
		User u = restT.getForObject("http://localhost:8080/users/id/"+uid, User.class);
		//User u = uRepo.findOne(uid);
		return getQuestionsService(u.getIntrestedTopics());
	}
	
	public List<Question> getExpertiseTopicQuestions(long uid) {
		//here there is dependency created for userManagement module.
		//This dependency can be removed by using the restTemplate
		//User u = uRepo.findOne(uid);
		RestTemplate restT = new RestTemplate();
		User u = restT.getForObject("http://localhost:8080/users/id/"+uid, User.class);
		
		return getQuestionsService(u.getExpertiseTopics());
	}

}
