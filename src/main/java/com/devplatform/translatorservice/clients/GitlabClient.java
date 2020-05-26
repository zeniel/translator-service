package com.devplatform.translatorservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devplatform.model.event.gitlab.GitlabUser;

@FeignClient(name = "gitlab", url = "https://git.cnj.jus.br", configuration = GitlabClientConfiguration.class)
public interface GitlabClient {
	@RequestMapping(method = RequestMethod.GET, value = "/api/v4/user", consumes = "application/json")
	public GitlabUser obterUsuarioLogado();
}
