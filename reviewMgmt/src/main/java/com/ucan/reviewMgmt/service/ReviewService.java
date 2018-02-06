package com.ucan.reviewMgmt.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucan.sharedLib.Review;
import com.ucan.reviewMgmt.repository.ReviewRepository;

@Service
public class ReviewService {
	@Autowired(required = true)
	ReviewRepository reviewRepo;

	public List<Review> getAllReviews() {

		List<Review> reviewList = new ArrayList<Review>();
		System.out.println("in get review Db service");
		Iterator<Review> reviewIterator = reviewRepo.findAll().iterator();
		while (reviewIterator.hasNext()) {
			reviewList.add(reviewIterator.next());
		}
		return reviewList;
	}

	public Review getOneReview(long id) {
		try {
			Review u = reviewRepo.findOne(id);
			System.out.println("in get one db review service");
			return u;
		} catch (Exception e) {
			return null;
		}

	}

	public List<Review> createReview(Review u) {
		System.out.println("in post db review service");
		try {
			reviewRepo.save(u);
			return getAllReviews();
		} catch (Exception e) {
			return null;
		}
	}

	public List<Review> updateReview(Review newU, long id) {
		System.out.println("in put review db service");

		reviewRepo.save(newU);
		return getAllReviews();
	}

	public List<Review> deleteReview(long id) {
		try {
			System.out.println("in delete review service");
			reviewRepo.delete(id);
			return getAllReviews();
		} catch (Exception e) {
			return null;
		}
	}

}
