package com.devplatform.translatorservice.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;

@Configuration
public class GitlabClientConfiguration {
	@Autowired
	private ClientsProperties clientsProperties;
	private static final String AUTH_TOKEN_HEADER = "PRIVATE-TOKEN";
	
	@Bean
	public RequestInterceptor gitlabRequestInterceptor() {
	  return requestTemplate -> {
	      requestTemplate.header(AUTH_TOKEN_HEADER, clientsProperties.getGitlabAccesstoken());
	  };
	}
}