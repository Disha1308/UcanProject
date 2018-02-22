package com.ucan.answerMgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucan.answerMgmt.repository.AnswerRepository;
import com.ucan.sharedLib.Answer;

@Service
public class QuestionAnswerService {
	
	@Autowired
	AnswerRepository answerRepo;

	public List<Answer> getAllAnswers(long questionId) {
		return answerRepo.findByownerQuestionId(questionId);
	
	}

	public List<Answer> getUserAllAnswers(long userId) {
		return answerRepo.findByownerUserId(userId);
	}
	
	public void upvoteAnswer(long sId) 
	{
		Answer q = answerRepo.findOne(sId);
		long upvote = q.getUpvoteCount() + 1;
		q.setUpvoteCount(upvote);
		answerRepo.save(q);
	}
	
	public void downvoteAnswer(long sId) 
	{
		Answer q = answerRepo.findOne(sId);
		long upvote = q.getDownvoteCount() + 1;
		q.setDownvoteCount(upvote);
		answerRepo.save(q);
	}
}
