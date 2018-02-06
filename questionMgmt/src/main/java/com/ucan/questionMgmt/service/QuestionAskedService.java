package com.ucan.questionMgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucan.questionMgmt.repository.QuestionRepository;
import com.ucan.sharedLib.Question;

@Service
public class QuestionAskedService {
	@Autowired(required = true)
	QuestionRepository questionRepo;

	public List<Question> getAllQuestions(long userId) {

		return questionRepo.findByownerUserId(userId);
	}

	public void upvoteQuestion(long qId) 
	{
		Question q = questionRepo.findOne(qId);
		long upvote = q.getUpvoteCount() + 1;
		q.setUpvoteCount(upvote);
		questionRepo.save(q);
	}
	
	public void downvoteQuestion(long qId) 
	{
		Question q = questionRepo.findOne(qId);
		long upvote = q.getDownvoteCount() + 1;
		q.setDownvoteCount(upvote);
		questionRepo.save(q);
	}

}
