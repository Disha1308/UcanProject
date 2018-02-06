package com.ucan.reviewMgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ucan.sharedLib.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

	List<Review> findByownerAnswerId(long answerId);

	List<Review> findByownerUserId(long userId);

}
