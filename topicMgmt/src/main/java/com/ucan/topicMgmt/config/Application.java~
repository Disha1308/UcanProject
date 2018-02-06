package com.ucan.topicMgmt.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {

		System.getProperties().put( "server.port", 8081 );
		SpringApplication.run(Application.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(apClass);
		
	}
	private static Class<Application> apClass = Application.class;
}
