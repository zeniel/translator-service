package com.devplatform.translatorservice.clients;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "service")
public class ClientsProperties {

    private String gitlabUrl;
    private String gitlabAccesstoken;
    private String jiraUrl;
    private String jiraUser;
    private String jiraPass;
    
    private String slackUrl;
    private String slackAppId;
    private String slackClientId;
    private String slackClientSecret;
    private String slackSignSecret;
    private String slackVerificationToken;
    private String slackUserToken;
    private String slackBotToken;
    private String slackChannelCloudReleases;
    
	public String getGitlabUrl() {
		return gitlabUrl;
	}
	public void setGitlabUrl(String gitlabUrl) {
		this.gitlabUrl = gitlabUrl;
	}
	public String getGitlabAccesstoken() {
		return gitlabAccesstoken;
	}
	public void setGitlabAccesstoken(String gitlabAccesstoken) {
		this.gitlabAccesstoken = gitlabAccesstoken;
	}
	public String getJiraUrl() {
		return jiraUrl;
	}
	public void setJiraUrl(String jiraUrl) {
		this.jiraUrl = jiraUrl;
	}
	public String getJiraUser() {
		return jiraUser;
	}
	public void setJiraUser(String jiraUser) {
		this.jiraUser = jiraUser;
	}
	public String getJiraPass() {
		return jiraPass;
	}
	public void setJiraPass(String jiraPass) {
		this.jiraPass = jiraPass;
	}
	public String getSlackUrl() {
		return slackUrl;
	}
	public void setSlackUrl(String slackUrl) {
		this.slackUrl = slackUrl;
	}

	public String getSlackAppId() {
		return slackAppId;
	}
	public void setSlackAppId(String slackAppId) {
		this.slackAppId = slackAppId;
	}
	public String getSlackClientId() {
		return slackClientId;
	}
	public void setSlackClientId(String slackClientId) {
		this.slackClientId = slackClientId;
	}
	public String getSlackClientSecret() {
		return slackClientSecret;
	}
	public void setSlackClientSecret(String slackClientSecret) {
		this.slackClientSecret = slackClientSecret;
	}
	public String getSlackSignSecret() {
		return slackSignSecret;
	}
	public void setSlackSignSecret(String slackSignSecret) {
		this.slackSignSecret = slackSignSecret;
	}
	public String getSlackVerificationToken() {
		return slackVerificationToken;
	}
	public void setSlackVerificationToken(String slackVerificationToken) {
		this.slackVerificationToken = slackVerificationToken;
	}
	public String getSlackToken() {
		return getSlackBotToken();
	}
	public String getSlackUserToken() {
		return slackUserToken;
	}
	public void setSlackUserToken(String slackUserToken) {
		this.slackUserToken = slackUserToken;
	}
	public String getSlackBotToken() {
		return slackBotToken;
	}
	public void setSlackBotToken(String slackBotToken) {
		this.slackBotToken = slackBotToken;
	}
	public String getSlackChannelCloudReleases() {
		return slackChannelCloudReleases;
	}
	public void setSlackChannelCloudReleases(String slackChannelCloudReleases) {
		this.slackChannelCloudReleases = slackChannelCloudReleases;
	}
	
}