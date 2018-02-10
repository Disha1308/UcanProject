package com.ucan.answerMgmt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ucan.answerMgmt.service.QuestionAnswerService;
import com.ucan.sharedLib.Answer;
import com.ucan.sharedLib.URLConstants;


@Controller
@RequestMapping(value="/v1.0/")
public class QuestionAnswerRest 
{
	@Autowired
	QuestionAnswerService answerServe;

	/* Get function for answer belonging to particular question */
	@RequestMapping(value=URLConstants.GET_QUESTION_ANSWERS_URL,produces="application/json")
	public @ResponseBody List<Answer> getAllAnswers(@PathVariable("questionid") long questionId) {
		List<Answer> answerList = answerServe.getAllAnswers(questionId);
		return answerList;

	}
	
	/* Get function for answer belonging to particular user */
	
	@RequestMapping(value=URLConstants.GET_USER_ANSWERS_URL,produces="application/json")
	public @ResponseBody List<Answer> getAllAnswersOfUsers(@PathVariable("userid") long userId) {
		List<Answer> answerList = answerServe.getUserAllAnswers(userId);
		return answerList;

	}

	/* POST function to upvote a answer */
	@RequestMapping(value=URLConstants.POST_ANSWER_UPVOTE,method=RequestMethod.POST)
	public void upvoteAnswer(@PathVariable("answerid") long aId) {
		answerServe.upvoteAnswer(aId);
	}
	
	/* POST function to downvote a answer */
	@RequestMapping(value=URLConstants.POST_ANSWER_DOWNVOTE,method=RequestMethod.POST)
	public void downvoteQuestion(@PathVariable("answerid") long aId) {
		answerServe.downvoteAnswer(aId);
	}

}
