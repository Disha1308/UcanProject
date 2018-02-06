package com.ucan.topicMgmt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ucan.sharedLib.Topic;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {

}
