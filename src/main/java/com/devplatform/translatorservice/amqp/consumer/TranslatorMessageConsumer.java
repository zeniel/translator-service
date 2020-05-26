package com.devplatform.translatorservice.amqp.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.devplatform.model.event.gitlab.GitlabEvent;
import com.devplatform.model.event.jira.JiraEvent;
import com.devplatform.model.event.slack.SlackChannelMessage;
import com.devplatform.translatorservice.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class TranslatorMessageConsumer {

	private static final Logger logger = LoggerFactory.getLogger(TranslatorMessageConsumer.class);
    
	@Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UserService userService;
    
	public final static String AMQP_HEADER_TYPEID = "__TypeId__";
	
	@Value("${rawevent.gitlab.general}")
	private String EVENTS_GITLAB_GENERAL;
	
	@Value("${rawevent.jira.issue}")
	private String EVENTS_JIRA_ISSUE;

	@Value("${rawevent.slack.message}")
	private String EVENTS_SLACK_MESSAGE;

	@RabbitListener(
			bindings = @QueueBinding(
				value = @Queue(value = "${rabbitmq.queueNameRawEvents}", durable = "true", autoDelete = "false", exclusive = "false"), 
				exchange = @Exchange(value = "{rabbitmq.exchangeName}", type = ExchangeTypes.TOPIC), 
				key = {"${rabbitmq.routingKeyPrefix}.#"})
		)
	public void receiveRawEventFromBroker(Message msg) throws Exception {
		if(msg != null && msg.getBody() != null 
				&& msg.getMessageProperties() != null && msg.getMessageProperties().getHeader(AMQP_HEADER_TYPEID) != null) {
			String messageType = msg.getMessageProperties().getHeader(AMQP_HEADER_TYPEID);
			String body = new String(msg.getBody());

			logger.info("[AMQP MESSAGE RECEIVED] " + new String(msg.toString()));
			if(messageType.endsWith(EVENTS_GITLAB_GENERAL)) {
				GitlabEvent gitlabEvent = objectMapper.readValue(body, GitlabEvent.class);
				logger.info("[GITLAB] - " + gitlabEvent.getObjectKind().name());
				// TODO - Implement gitlab translator
				userService.teste();
			}else if(messageType.endsWith(EVENTS_JIRA_ISSUE)) {
				JiraEvent jiraEvent = objectMapper.readValue(body, JiraEvent.class);
				logger.info("[JIRA] - " + jiraEvent.getIssueEventTypeName().name());
				// TODO - Implement jira issue translator
			}else if(messageType.endsWith(EVENTS_SLACK_MESSAGE)) {
				SlackChannelMessage slackMessage = objectMapper.readValue(body, SlackChannelMessage.class);
				logger.info("[SLACK] - " + slackMessage.getText());
				// TODO - Implement slack channel message translator
			}
		}
	}	
	
}
