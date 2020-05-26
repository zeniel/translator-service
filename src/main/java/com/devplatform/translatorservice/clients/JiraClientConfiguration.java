package com.devplatform.translatorservice.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class JiraClientConfiguration {
	@Autowired
	private ClientsProperties clientsProperties;
	
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(clientsProperties.getJiraUser(), clientsProperties.getJiraPass());
    }
}