package com.ucan.questionMgmt.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ucan.questionMgmt.repository.QuestionRepository;
import com.ucan.sharedLib.Question;
import com.ucan.sharedLib.Topic;
import com.ucan.sharedLib.User;

@Service
public class QuestionService {
	@Autowired(required = true)
	QuestionRepository questionRepo;

	public List<Question> getAllQuestionsService() {

		List<Question> questionList = new ArrayList<Question>();
		System.out.println("in get question Db service");
		Iterator<Question> questionIterator = questionRepo.findAll().iterator();
		while (questionIterator.hasNext()) {
			questionList.add(questionIterator.next());
		}
		return questionList;
	}


	public Question getOneQuestionService(long id) {
		try {
			Question u = questionRepo.findOne(id);
			System.out.println("in get one db question service");
			return u;
		} catch (Exception e) {
			return null;
		}

	}

	public List<User> createQuestionService(Question u) {
		System.out.println("in post db question service");
		try {
			questionRepo.save(u);
			RestTemplate restT = new RestTemplate();
			List<User> experts = new ArrayList<User>();
			Iterator<Topic> tagit = u.getTags().iterator();
			while(tagit.hasNext())
			{
				long tagid = tagit.next().getId();
				ResponseEntity < List < User >> response =restT.exchange("http://localhost:8080/v1.0/topics/"+tagid+"/experts/", HttpMethod.GET, null, new ParameterizedTypeReference < List < User >> () {});
				experts.addAll(response.getBody());
			}
			return experts;
			} 
		catch (Exception e) {
			return null;
		}
	}

	public List<Question> updateQuestionService(Question newU, long id) {
		System.out.println("in put question db service");

		questionRepo.save(newU);
		return getAllQuestionsService();
	}

	public List<Question> deleteQuestionService(long id) {
		try {

			System.out.println("in delete question service");
			questionRepo.delete(id);
			return getAllQuestionsService();
		} catch (Exception e) {
			return null;
		}
	}

	

}
