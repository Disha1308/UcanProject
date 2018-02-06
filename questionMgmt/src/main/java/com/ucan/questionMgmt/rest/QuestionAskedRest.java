package com.ucan.questionMgmt.rest;

import java.util.List;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.ucan.questionMgmt.service.QuestionAskedService;
import com.ucan.sharedLib.Question;
import com.ucan.sharedLib.URLConstants;

@Named
@Path("/v1.0/")
public class QuestionAskedRest {
	@Autowired
	QuestionAskedService questionServe;

	/* Get function for questions belonging to particular user */
	@GET
	@Path(URLConstants.GET_USER_ASKED_QUESTIONS_URL)
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Question> getAllQuestions(@PathParam("userid") long userId) {
		List<Question> questionList = questionServe.getAllQuestions(userId);
		return questionList;

	}
	
	/* POST function to upvote a question */
	@POST
	@Path(URLConstants.POST_QUESTION_UPVOTE)
	@Produces({ MediaType.APPLICATION_JSON })
	public void upvoteQuestion(@PathParam("questionid") long qId) {
		questionServe.upvoteQuestion(qId);
	}
	
	/* POST function to downvote a question */
	@POST
	@Path(URLConstants.POST_QUESTION_DOWNVOTE)
	@Produces({ MediaType.APPLICATION_JSON })
	public void downvoteQuestion(@PathParam("questionid") long qId) {
		questionServe.downvoteQuestion(qId);
	}

}
