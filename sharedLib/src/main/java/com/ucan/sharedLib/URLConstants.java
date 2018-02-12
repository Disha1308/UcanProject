package com.ucan.sharedLib;

public interface URLConstants {

	// Port 8080
	static final String GET_USER_URL = "/users/{email}";
	static final String GET_USER_ID_URL = "/users/id/{id}";
	static final String GET_USER_USERNAME_URL = "/users/username/{username}";
	static final String POST_USER_URL = "/users";
	static final String PUT_USER_URL = "/users/{id}";
	static final String DELETE_USER_URL = "/users/{id}";

	// Port 8080
	static final String GET_USER_INTEREST_TOPICS_URL = "/users/{userid}/interesttopics";
	static final String GET_USER_EXPERTISE_TOPICS_URL = "/users/{userid}/expertisetopics";
	static final String POST_USER_INTEREST_TOPICS_URL = "/user/{userid}/interesttopics";
	static final String POST_USER_EXPERTISE_TOPICS_URL = "/user/{userid}/expertisetopics";
	static final String DELETE_USER_INTEREST_TOPIC_URL = "users/{userid}/interestedtopics/{topicid}/";
	static final String DELETE_USER_EXPERTISE_TOPIC_URL = "users/{userid}/expertisetopics/{topicid}/";
	static final String GET_TOPIC_EXPERTS_URL = "/topics/{topicid}/experts/";
	static final String GET_TOPIC_FOLLOWERS_URL = "/topics/{topicid}/followers/";
	static final String GET_TOPICS_EXPERTS_URL = "/topics/experts/";
	

	// Port 8081
	static final String GET_TOPICS_URL = "/topics";
	static final String GET_TOPIC_URL = "/topics/{id}";
	static final String POST_TOPIC_URL = "/topics";
	static final String PUT_TOPIC_URL = "/topics/{id}";
	static final String DELETE_TOPIC_URL = "/topics/{id}";

	// Port 8082
	static final String GET_QUESTION_URL = "/questions/{id}";
	static final String POST_QUESTION_URL = "/questions";
	static final String PUT_QUESTION_URL = "/questions/{id}";
	static final String DELETE_QUESTION_URL = "/questions/{id}";

	// Port 8082
	static final String GET_USER_ASKED_QUESTIONS_URL = "/users/{userid}/questions";
	static final String POST_QUESTION_UPVOTE = "/question/{questionid}/upvote";
	static final String POST_QUESTION_DOWNVOTE = "/question/{questionid}/downvote";

	// Port 8082
	static final String GET_TAGS_QUESTION_URL = "/question/{questionid}/tags";
	static final String POST_TAGS_QUESTION_URL = "/question/{questionid}/tags";
	static final String GET_QUESTIONS_TAGS_URL = "/questions/tags";
	static final String GET_QUESTIONS_TOPIC_INTERESTED = "/user/{userid}/interestedtopic/questions";
	static final String GET_QUESTIONS_TOPIC_EXPERTISE = "/user/{userid}/expertisetopic/questions";
	
	//Port 8083
	static final String GET_ANSWER_URL = "/answers/{id}";
	static final String POST_ANSWER_URL = "/answers";
	static final String PUT_ANSWER_URL = "/answers/{id}";
	static final String DELETE_ANSWER_URL = "/answers/{id}";
	
	//Port 8083
	static final String GET_QUESTION_ANSWERS_URL = "/question/{questionid}/answers";
	static final String GET_USER_ANSWERS_URL = "/users/{userid}/answers";
	static final String POST_ANSWER_UPVOTE = "/answer/{answerid}/upvote";
	static final String POST_ANSWER_DOWNVOTE = "/answer/{answerid}/downvote";
	
	//Port 8083
	static final String POST_DISCUSSION_SESSION_URL = "/discussionsession";
	static final String GET_USER_DISCUSSION_SESSION_URL = "/user/{userid}/discussionsession";
	static final String GET_SESSION_ANSWERS_URL = "/discussionsession/{dsid}/answers";
	static final String POST_ANSWER_SESSION_UPVOTE = "/answersession/{discussionsession}/upvote";
	static final String POST_ANSWER_SESSION_DOWNVOTE = "/answersession/{discussionsession}/downvote";
	static final String GET_QUESTION_DISCUSSION_SESSION_URL = "/question/{questionid}/discussionsession";
	
	//Port 8085
	static final String GET_REVIEW_URL = "/reviews/{id}";
	static final String POST_REVIEW_URL = "/reviews";
	static final String PUT_REVIEW_URL = "/reviews/{id}";
	static final String DELETE_REVIEW_URL = "/reviews/{id}";
	static final String GET_ANSWER_REVIEWS_URL = "/answers/{answerid}/reviews";
	static final String GET_USER_REVIEWS_URL = "/users/{userid}/reviews";
	
	
	//Port 8089
	static final String POST_NEGOTIATION_SESSION_URL = "/negotiationSession";
	static final String GET_USER_NEGOTIATION_SESSION_URL =	"/user/{userid}/negotiationsession";	
	static final String POST_NEGOTIATION_MESSAGE_URL =	"/negotiationmessage";
	static final String GET_NEGOTIATION_MESSAGE_URL =	"/negotiationmessage/{id}";
	static final String GET_SESSION_NEGOTIATION_MESSAGES_URL = "/negotiationSession/{sessionid}/negotiationmessages";
	
}
