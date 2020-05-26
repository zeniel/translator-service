package com.devplatform.translatorservice.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devplatform.model.event.gitlab.GitlabUser;
import com.devplatform.model.event.jira.JiraUser;
import com.devplatform.translatorservice.clients.ClientsProperties;
import com.devplatform.translatorservice.clients.GitlabClient;
import com.devplatform.translatorservice.clients.JiraClient;
import com.devplatform.translatorservice.clients.SlackClient;
import com.devplatform.translatorservice.clients.queryparam.SlackGetUsersInfoQueryParam;

@Component
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private ClientsProperties clientsProperties;
	
    @Autowired
    private GitlabClient gitlabClient;

    @Autowired
    private JiraClient jiraClient;

    @Autowired
    private SlackClient slackClient;


    public void teste() {
		logger.info("Trying to get user information from service GITLAB: ");
		if(gitlabClient != null) {
			GitlabUser usuarioLogado = gitlabClient.obterUsuarioLogado();
			logger.info(usuarioLogado.toString());
		}else {
			logger.error("client feign not initialized");
		}

		logger.info("Trying to get user information from service JIRA: ");
		if(jiraClient != null) {
			JiraUser usuarioLogadoJira = jiraClient.obterUsuarioLogado();
			logger.info(usuarioLogadoJira.toString());
		}else {
			logger.error("client feign not initialized");
		}


		logger.info("Trying to get user information from service Slack: ");
		if(slackClient != null) {
			SlackGetUsersInfoQueryParam userInfo = new SlackGetUsersInfoQueryParam(clientsProperties.getSlackToken(), "U3HHYMKLK");
			
			String usuarioLogadoSlack = slackClient.obterUsuarioLogado(userInfo);
			logger.info(usuarioLogadoSlack.toString());
		}else {
			logger.error("client feign not initialized");
		}
    }
}
