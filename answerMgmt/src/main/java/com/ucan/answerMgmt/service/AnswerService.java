package com.ucan.answerMgmt.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.ucan.sharedLib.Answer;
import com.ucan.sharedLib.User;
import com.ucan.answerMgmt.repository.AnswerRepository;

@Service
public class AnswerService {
	@Autowired(required = true)
	AnswerRepository answerRepo;
	

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	public List<Answer> getAllAnswers() {

		List<Answer> answerList = new ArrayList<Answer>();
		System.out.println("in get answer Db service");
		Iterator<Answer> answerIterator = answerRepo.findAll().iterator();
		while (answerIterator.hasNext()) {
			answerList.add(answerIterator.next());
		}
		return answerList;
	}

	public Answer getOneAnswer(long id) {
		try {
			Answer u = answerRepo.findOne(id);
			System.out.println("in get one db answer service");
			return u;
		} catch (Exception e) {
			return null;
		}

	}

	public void createAnswer(Answer u) {
		System.out.println("in post db answer service");
		try {
			answerRepo.save(u);
			u = answerRepo.findOne(u.getId());
			User sessionseeker = u.getSession().getSeeker();
			User sessionexpert = u.getSession().getExpert();

			if(u.getOwnerUser().getId() == sessionseeker.getId())
			{
				simpMessagingTemplate.convertAndSendToUser(sessionexpert.getEmail(), "/queue/reply", u);
			}
			else
			{
				simpMessagingTemplate.convertAndSendToUser(sessionseeker.getEmail(), "/queue/reply", u);
			}

		} catch (Exception e) {
			System.out.println("error in sending answer");
		}
	}

	public List<Answer> getSessionAnswers(long sid) {
		return answerRepo.findBysessionId(sid);
	}

}
