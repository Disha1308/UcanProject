package com.ucan.userMgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ucan.sharedLib.Topic;
import com.ucan.sharedLib.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> 
{
	List<User> findByinterestedTopics(Topic t);
	List<User> findByexpertiseTopics(Topic t);
	User findByemail(String email);
}
