package com.ucan.Negotiation.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ucan.sharedLib.NegotiationSession;



@Repository
public interface SessionRepository extends CrudRepository<NegotiationSession, Long> 
{
	List<NegotiationSession> findByseekerId(long uid);
	List<NegotiationSession> findByexpertId(long uid);
}
