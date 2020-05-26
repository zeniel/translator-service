package com.devplatform.translatorservice.amqp.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.devplatform.model.event.jira.JiraEvent;
import com.devplatform.model.event.jira.JiraEvent.WebhookEventEnum;
import com.devplatform.model.event.jira.JiraEventChangelogItems;

public class JiraEventHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(JiraEventHandler.class);
    
	
	public void handle(JiraEvent jiraEvent) throws Exception {
		if(jiraEvent.getWebhookEvent() == WebhookEventEnum.ISSUE_CREATED) {
			this.createEventIssueCreated(jiraEvent);
		}else if(jiraEvent.getWebhookEvent() == WebhookEventEnum.ISSUE_UPDATED) {
			this.identifyIssueUpdatedEvent(jiraEvent);
		}else {
			
		}
	}

	private void identifyIssueUpdatedEvent(JiraEvent jiraEvent) {
		if(jiraEvent.getChangelog() != null && jiraEvent.getChangelog().getItems() != null && jiraEvent.getChangelog().getItems().size() > 0) {
			for (JiraEventChangelogItems item : jiraEvent.getChangelog().getItems()) {
				if(item.getField().equals("comment")) {
					
				}
			}
			
		}
	}

	// TODO - create this event
	private void createEventIssueCreated(JiraEvent jiraEvent) {
		logger.info("Issue was created... payload pending!");
	}

	// TODO - create this event
	private void createEventNewComment(JiraEvent jiraEvent) {
		logger.info("It is there a new comment... payload pending!");
	}

}
