package com.ucan.answerMgmt.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan({ "com.ucan.answerMgmt.service", "com.ucan.answerMgmt.rest" })
@EntityScan(basePackages = { "com.ucan.sharedLib" })
@EnableJpaRepositories(basePackages = "com.ucan.answerMgmt.repository")
public class ApplicationConfig {


}