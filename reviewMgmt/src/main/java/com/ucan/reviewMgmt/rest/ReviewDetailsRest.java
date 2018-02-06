package com.ucan.reviewMgmt.rest;

import java.util.List;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.ucan.reviewMgmt.service.ReviewDetailsService;
import com.ucan.sharedLib.Review;
import com.ucan.sharedLib.URLConstants;

@Named
@Path("/v1.0/")
public class ReviewDetailsRest 
{
	@Autowired
	ReviewDetailsService reviewServe;

	/* Get function for review belonging to particular answer */
	@GET
	@Path(URLConstants.GET_ANSWER_REVIEWS_URL)
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Review> getAllReviews(@PathParam("answerid") long answerid) {
		List<Review> reviewList = reviewServe.getAllReviews(answerid);
		return reviewList;

	}
	
	/* Get function for review belonging to particular user */
	@GET
	@Path(URLConstants.GET_USER_REVIEWS_URL)
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Review> getAllReviewsOfUsers(@PathParam("userid") long userId) {
		List<Review> reviewList = reviewServe.getUserAllReviews(userId);
		return reviewList;

	}

}
