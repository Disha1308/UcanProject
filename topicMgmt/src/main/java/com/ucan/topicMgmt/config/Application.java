package com.ucan.topicMgmt.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.ucan.sharedLib.PortConstants;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {

		System.getProperties().put( "server.port", PortConstants.TOPICMGMT );
		SpringApplication.run(Application.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(apClass);
		
	}
	private static Class<Application> apClass = Application.class;
}
