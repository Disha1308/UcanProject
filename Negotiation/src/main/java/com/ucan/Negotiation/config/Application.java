package com.ucan.Negotiation.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {

		System.getProperties().put( "server.port", 8089 );
		SpringApplication.run(Application.class, args);
	}
}