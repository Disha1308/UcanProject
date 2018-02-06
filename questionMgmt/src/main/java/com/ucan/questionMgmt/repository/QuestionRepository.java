package com.ucan.questionMgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ucan.sharedLib.Question;
import com.ucan.sharedLib.Topic;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

	public List<Question> findByownerUserId(long topicid);

	public List<Question> findBytags(Topic t);
	

}
