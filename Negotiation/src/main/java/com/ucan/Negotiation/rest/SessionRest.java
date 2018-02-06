package com.ucan.Negotiation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ucan.Negotiation.service.SessionService;
import com.ucan.sharedLib.NegotiationSession;
import com.ucan.sharedLib.URLConstants;


@Controller
@RequestMapping(value="/v1.0/")
public class SessionRest {
	
	@Autowired(required = true)
	SessionService sService;
	
	
	@RequestMapping(value=URLConstants.POST_NEGOTIATION_SESSION_URL,method=RequestMethod.POST)
	public void createSession(@RequestBody List<NegotiationSession> sessionList) {
		System.out.println("in post db session service");
		sService.createSession(sessionList);		
	}
	
	
	@RequestMapping(value=URLConstants.GET_USER_NEGOTIATION_SESSION_URL,method=RequestMethod.GET, produces="application/json")
	public @ResponseBody  List<NegotiationSession> getUserNegotiationSession(@PathVariable("userid") long uid)
	{
		return sService.getUserSession(uid);
	}

}
