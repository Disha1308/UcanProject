package com.ucan.topicMgmt.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucan.sharedLib.Topic;
import com.ucan.topicMgmt.repository.TopicRepository;

@Service
public class TopicService {
	@Autowired(required = true)
	TopicRepository topicRepo;

	public List<Topic> getAllTopics() {

		List<Topic> topicList = new ArrayList<Topic>();
		System.out.println("in get topic Db service");
		Iterator<Topic> topicIterator = topicRepo.findAll().iterator();
		while (topicIterator.hasNext()) {
			topicList.add(topicIterator.next());
		}
		return topicList;
	}

	public Topic getOneTopic(long id) {
		try {
			Topic u = topicRepo.findOne(id);
			System.out.println("in get one db topic service");
			return u;
		} catch (Exception e) {
			return null;
		}

	}

	public List<Topic> createTopic(Topic u) {
		System.out.println("in post db topic service");
		try {
			topicRepo.save(u);
			return getAllTopics();
		} catch (Exception e) {
			return null;
		}
	}

	public List<Topic> updateTopic(Topic newU, long id) {
		System.out.println("in put topic db service");

		topicRepo.save(newU);
		return getAllTopics();
	}

	public List<Topic> deleteTopic(long id) {
		try {

			System.out.println("in delete topic service");
			topicRepo.delete(id);
			return getAllTopics();
		} catch (Exception e) {
			return null;
		}
	}

}
