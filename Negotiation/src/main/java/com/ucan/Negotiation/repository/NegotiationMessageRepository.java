package com.ucan.Negotiation.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ucan.sharedLib.NegotiationMessage;

@Repository
public interface NegotiationMessageRepository extends CrudRepository<NegotiationMessage, Long> {

	List<NegotiationMessage> findBynegoSessionId(long sid);

}

