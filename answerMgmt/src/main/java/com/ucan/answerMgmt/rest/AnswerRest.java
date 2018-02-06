package com.ucan.answerMgmt.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ucan.sharedLib.URLConstants;
import com.ucan.sharedLib.Answer;
import com.ucan.answerMgmt.service.AnswerService;

@Controller
@RequestMapping(value="/v1.0/")
public class AnswerRest {
	@Autowired
	AnswerService answerServe;

	
	@RequestMapping(value=URLConstants.GET_ANSWER_URL,method=RequestMethod.GET,produces="application/json")
	public Answer getAnswer(@PathVariable("id") long id) {
		System.out.println("in get one db answer service");
		Answer u = answerServe.getOneAnswer(id);

		return u;

	}

	
	@MessageMapping(value=URLConstants.POST_ANSWER_URL)
	public void createAnswer(String u) {
		System.out.println("in post db answer service");
		u = u.replaceAll("\\\\", "");
		ObjectMapper mapper = new ObjectMapper();
		Answer msg;
		try {
			msg = mapper.readValue(u, Answer.class);
			answerServe.createAnswer(msg);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@RequestMapping(value=URLConstants.GET_SESSION_ANSWERS_URL,method=RequestMethod.GET,produces="application/json")
	public List<Answer> getSessionAnswers(@PathVariable("dsid") long sid) {
		System.out.println("in get one db message service");
		List<Answer> answerList = answerServe.getSessionAnswers(sid);

		return answerList;

	}
}
