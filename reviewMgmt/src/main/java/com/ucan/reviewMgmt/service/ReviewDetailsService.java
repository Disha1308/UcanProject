package com.ucan.reviewMgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ucan.reviewMgmt.repository.ReviewRepository;
import com.ucan.sharedLib.Review;

public class ReviewDetailsService {
	
	@Autowired
	ReviewRepository reviewRepo;


	public List<Review> getAllReviews(long answerId) {
		return reviewRepo.findByownerAnswerId(answerId);
	}

	public List<Review> getUserAllReviews(long userId) {
		return reviewRepo.findByownerUserId(userId);
	}

}
