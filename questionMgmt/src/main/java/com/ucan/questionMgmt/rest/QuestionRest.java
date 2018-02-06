package com.ucan.questionMgmt.rest;

import java.util.List;

import javax.inject.Named;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.ucan.questionMgmt.service.QuestionService;
import com.ucan.sharedLib.URLConstants;
import com.ucan.sharedLib.Question;
import com.ucan.sharedLib.User;

@Named
@Path("/v1.0/")
public class QuestionRest {
	@Autowired
	QuestionService questionServe;

		
	/*  	fUNCTION TO FETCH particular question IN SYSTEM */
	@GET
	@Path(URLConstants.GET_QUESTION_URL)
	@Produces(MediaType.APPLICATION_JSON)
	public Question getQuestion(@PathParam("id") long id) {
		System.out.println("in get one db question service");
		Question u = questionServe.getOneQuestionService(id);

		return u;

	}
	
	/* function to post a question */
	@POST
	@Path(URLConstants.POST_QUESTION_URL)
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> createQuestion(@RequestBody Question u) {
		System.out.println("in post db question service");
		return questionServe.createQuestionService(u);
	}

		
	/* Update a question in system */
	@PUT
	@Path(URLConstants.PUT_QUESTION_URL)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateQuestion(@RequestBody Question u, @PathParam("id") long id) {
		System.out.println("in put question db service");
		questionServe.updateQuestionService(u, id);

	}

	
	/* Delete a question in the system */
	@DELETE
	@Path(URLConstants.DELETE_QUESTION_URL)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteQuestion(@PathParam("id") long id) {
		System.out.println("in delete question service");
		questionServe.deleteQuestionService(id);

	}
	
}
