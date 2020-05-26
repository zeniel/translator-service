package com.devplatform.translatorservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devplatform.model.event.jira.JiraUser;

@FeignClient(name = "jira", url = "https://www.cnj.jus.br/jira", configuration = JiraClientConfiguration.class)
public interface JiraClient {
	@RequestMapping(method = RequestMethod.GET, value = "/rest/auth/1/session", consumes = "application/json")
	public JiraUser obterUsuarioLogado();
}
