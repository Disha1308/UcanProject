package com.ucan.answerMgmt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ucan.answerMgmt.service.DiscussionSessionService;
import com.ucan.sharedLib.DiscussionSession;
import com.ucan.sharedLib.URLConstants;

@Controller
@RequestMapping(value="/v1.0/")
public class DiscussionSessionRest {
	
	@Autowired
	DiscussionSessionService sService;
	
	@MessageMapping(value=URLConstants.POST_DISCUSSION_SESSION_URL)
	public void createDiscussionSession(@RequestBody List<DiscussionSession> sessionList) {
		System.out.println("in post db session service");
		sService.createDiscussionSession(sessionList);		
	}
	

	@RequestMapping(value=URLConstants.GET_USER_DISCUSSION_SESSION_URL,produces="application/json")
	public @ResponseBody List<DiscussionSession> getUserDiscussionSession(@PathVariable("userid") long uid)
	{
		return sService.getUserDiscussionSession(uid);
	}
	
	
	/* POST function to upvote a answer session */
	@RequestMapping(value=URLConstants.POST_ANSWER_UPVOTE,method=RequestMethod.POST)
	public void upvoteAnswer(@PathVariable("discussionsession") long sId) {
		sService.upvoteAnswer(sId);
	}
	
	/* POST function to downvote a answer */
	@RequestMapping(value=URLConstants.POST_ANSWER_DOWNVOTE,method=RequestMethod.POST)
	public void downvoteQuestion(@PathVariable("discussionsession") long sId) {
		sService.downvoteAnswer(sId);
	}
	
	@RequestMapping(value=URLConstants.GET_QUESTION_DISCUSSION_SESSION_URL,produces="application/json")
	public @ResponseBody List<DiscussionSession> getQuestionDiscussionSession(@PathVariable("questionid") long qid)
	{
		return sService.getQuestionDiscussionSession(qid);
	}

}