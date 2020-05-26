package com.devplatform.translatorservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devplatform.translatorservice.clients.queryparam.SlackGetUsersInfoQueryParam;

@FeignClient(name = "slack", url = "https://slack.com/api/", configuration = JiraClientConfiguration.class)
public interface SlackClient {
	@RequestMapping(method = RequestMethod.GET, value = "users.info", consumes = "application/json")
	public String obterUsuarioLogado(@SpringQueryMap SlackGetUsersInfoQueryParam user);
}
