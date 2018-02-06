package com.ucan.Negotiation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ucan.Negotiation.service.SessionMessageService;
import com.ucan.sharedLib.NegotiationMessage;
import com.ucan.sharedLib.URLConstants;


@Controller
@RequestMapping(value="/v1.0")
public class SessionMessageRest {
	
	@Autowired(required = true)
	SessionMessageService messageServe;
	
	
	
	@RequestMapping(value=URLConstants.GET_NEGOTIATION_MESSAGE_URL,method=RequestMethod.GET,produces="application/json")
	public @ResponseBody NegotiationMessage getMessage(@PathVariable("id") long id) {
		System.out.println("in get one db message service");
		NegotiationMessage u = messageServe.getOneNegotiationMessage(id);

		return u;

	}

	@MessageMapping(value=URLConstants.POST_NEGOTIATION_MESSAGE_URL)
	public void createMessage(String u) {
		System.out.println("in post db message service"+u);
	
		u = u.replaceAll("\\\\", "");

		System.out.println("in post db message service"+u);
		ObjectMapper mapper = new ObjectMapper();
		try {
			NegotiationMessage msg = mapper.readValue(u, NegotiationMessage.class);

			messageServe.createNegotiationMessage(msg);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	
	}
	

	@RequestMapping(value=URLConstants.GET_SESSION_NEGOTIATION_MESSAGES_URL,method=RequestMethod.GET,produces="application/json")
	public @ResponseBody List<NegotiationMessage> getSessionMessage(@PathVariable("sessionid") long sid) {
		System.out.println("in get one db message service");
		List<NegotiationMessage> messageList = messageServe.getSessionMessages(sid);

		return messageList;

	}

}
