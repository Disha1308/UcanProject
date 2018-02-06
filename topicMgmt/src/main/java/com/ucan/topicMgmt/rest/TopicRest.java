package com.ucan.topicMgmt.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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

import com.ucan.sharedLib.URLConstants;
import com.ucan.sharedLib.Topic;
import com.ucan.topicMgmt.service.TopicService;

@Named
@Path("/v1.0/")
@Api(value = "Topic Management resource", produces = "application/json")
public class TopicRest {
	@Autowired
	TopicService topicServe;

	@GET
	@Path(URLConstants.GET_TOPICS_URL)
	@ApiOperation(value = "get topic by id")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Topic> getAllTopics() {
		List<Topic> topicList = topicServe.getAllTopics();
		return topicList;

	}

	@GET
	@Path(URLConstants.GET_TOPIC_URL)
	@Produces(MediaType.APPLICATION_JSON)
	public Topic getTopic(@PathParam("id") long id) {
		System.out.println("in get one db topic service");
		Topic u = topicServe.getOneTopic(id);

		return u;

	}

	@POST
	@Path(URLConstants.POST_TOPIC_URL)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Topic> createTopic(@RequestBody Topic u) {
		System.out.println("in post db topic service");
		topicServe.createTopic(u);
		return getAllTopics();
	}

	@PUT
	@Path(URLConstants.PUT_TOPIC_URL)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Topic> updateTopic(@RequestBody Topic u, @PathParam("id") long id) {
		System.out.println("in put topic db service");
		return topicServe.updateTopic(u, id);

	}

	@DELETE
	@Path(URLConstants.DELETE_TOPIC_URL)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Topic> deleteTopic(@PathParam("id") long id) {
		System.out.println("in delete topic service");
		return topicServe.deleteTopic(id);

	}

}
