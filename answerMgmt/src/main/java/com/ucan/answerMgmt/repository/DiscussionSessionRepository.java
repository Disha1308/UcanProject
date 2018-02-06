package com.ucan.answerMgmt.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ucan.sharedLib.DiscussionSession;



@Repository
public interface DiscussionSessionRepository extends CrudRepository<DiscussionSession, Long> 
{
	List<DiscussionSession> findByseekerId(long uid);
	List<DiscussionSession> findByexpertId(long uid);
	List<DiscussionSession> findByquestionId(long qid);
}
