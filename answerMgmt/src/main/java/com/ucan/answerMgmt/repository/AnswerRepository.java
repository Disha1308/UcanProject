package com.ucan.answerMgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ucan.sharedLib.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> 
{
	List<Answer> findByownerUserId(long userId);
	List<Answer> findBysessionId(long sid);
	List<Answer> findByownerQuestionId(long qid);
	
}
