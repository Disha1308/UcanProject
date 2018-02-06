package com.ucan.reviewMgmt.rest;


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
import com.ucan.sharedLib.Review;
import com.ucan.reviewMgmt.service.ReviewService;

@Named
@Path("/v1.0/")
public class ReviewRest {
	@Autowired
	ReviewService reviewServe;

	@GET
	@Path(URLConstants.GET_REVIEW_URL)
	@Produces(MediaType.APPLICATION_JSON)
	public Review getReview(@PathParam("id") long id) {
		System.out.println("in get one db review service");
		Review u = reviewServe.getOneReview(id);

		return u;

	}

	@POST
	@Path(URLConstants.POST_REVIEW_URL)
	@Produces(MediaType.APPLICATION_JSON)
	public void createReview(@RequestBody Review u) {
		System.out.println("in post db review service");
		reviewServe.createReview(u);
	}

	@PUT
	@Path(URLConstants.PUT_REVIEW_URL)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateReview(@RequestBody Review u, @PathParam("id") long id) {
		System.out.println("in put review db service");
		reviewServe.updateReview(u, id);

	}

	@DELETE
	@Path(URLConstants.DELETE_REVIEW_URL)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteReview(@PathParam("id") long id) {
		System.out.println("in delete review service");
		reviewServe.deleteReview(id);

	}

}
