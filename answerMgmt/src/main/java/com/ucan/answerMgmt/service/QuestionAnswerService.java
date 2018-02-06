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
	
	
}
