package com.ucan.userMgmt.rest;

import java.util.List;
import javax.inject.Named;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.ucan.userMgmt.service.TopicSubscriptionService;
import com.ucan.sharedLib.Topic;
import com.ucan.sharedLib.User;
import com.ucan.sharedLib.URLConstants;

@Named
@Path("/v1.0/")
public class TopicSubscriptionRest {
	@Autowired
	TopicSubscriptionService userServe;

	/* Get function for interested topics belonging to particular user */
	@GET
	@Path(URLConstants.GET_USER_INTEREST_TOPICS_URL)
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Topic> getAllInterestedTopics(@PathParam("userid") long userId) {
		 return userServe.getAllInterestedTopics(userId);
	}

	/* Get function for expertise topics belonging to particular user */
	@GET
	@Path(URLConstants.GET_USER_EXPERTISE_TOPICS_URL)
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Topic> getAllExpertiseTopics(@PathParam("userid") long userId) {
		 return userServe.getAllExpertiseTopics(userId);
	}

	/* Get function for experts belonging to particular topic */
	@GET
	@Path(URLConstants.GET_TOPIC_EXPERTS_URL)
	@Produces({ MediaType.APPLICATION_JSON })
	public List<User> getAllExperts(@RequestBody List<Topic> topicId) {
		return userServe.getAllExperts(topicId);

	}

	/* Get function for followers belonging to particular topic */
	@GET
	@Path(URLConstants.GET_TOPIC_FOLLOWERS_URL)
	@Produces({ MediaType.APPLICATION_JSON })
	public List<User> getAllFollowers(@RequestBody List<Topic> topicId) {
		return userServe.getAllFollowers(topicId);
	}

	/* function: to subscribe a user to multiple interested topics.
	 * input   : Request Body - List of topics with id field, Path parameter the user id.
	 * output  : particular tag assigned to question.
	 */
	@POST
	@Path(URLConstants.POST_USER_INTEREST_TOPICS_URL)
	@Produces(MediaType.APPLICATION_JSON)
	public void subscribeInterestedTopics(@PathParam("userid") long uId,@RequestBody List<Topic> tList )
	{
		System.out.println("in post topic user service for multiple tags");
	    userServe.subscribeInterestedTopics(uId, tList);
	}
	
	/* function: to subscribe a user to multiple expertise topics.
	 * input   : Request Body - List of topics with id field, Path parameter the user id.
	 * output  : particular tag assigned to question.
	 */
	@POST
	@Path(URLConstants.POST_USER_EXPERTISE_TOPICS_URL)
	@Produces(MediaType.APPLICATION_JSON)
	public void subscribeExpertiseTopics(@PathParam("userid") long uId,@RequestBody List<Topic> tList )
	{
		System.out.println("in post topic user service for multiple tags");
	    userServe.subscribeExpertiseTopics(uId, tList);
	}

	/* Delete a interested topic followed by user */
	@DELETE
	@Path(URLConstants.DELETE_USER_INTEREST_TOPIC_URL)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteUserInterestedTopic(@PathParam("userid") long userid,@PathParam("topicid") long topicid) {
		System.out.println("in delete user service");
		userServe.UnsubscribeInterestedTopic(userid, topicid);
	}
	
	/* Delete a expertise topic followed by user */
	@DELETE
	@Path(URLConstants.DELETE_USER_EXPERTISE_TOPIC_URL)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteUserExpertiseTopic(@PathParam("userid") long userid,@PathParam("topicid") long topicid) {
		System.out.println("in delete user service");
		userServe.UnsubscribeExpertiseTopic(userid, topicid);
	}

}
