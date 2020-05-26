package com.devplatform.translatorservice.amqp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rabbitmq")
public class RabbitMQProperties {

    private String queueNameDefault;
    private String queueNameRawEvents;
    private String exchangeName;
    private String routingKeyPrefix;
    private Integer maxConcurrentConsumers;

    public String getQueueNameDefault() {
		return queueNameDefault;
	}

	public void setQueueNameDefault(String queueNameDefault) {
		this.queueNameDefault = queueNameDefault;
	}
	
	public String getQueueNameRawEvents() {
		return queueNameRawEvents;
	}

	public void setQueueNameRawEvents(String queueNameRawEvents) {
		this.queueNameRawEvents = queueNameRawEvents;
	}

	public String getExchangeName() {
        return exchangeName;
    }
    
    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getRoutingKeyPrefix() {
        return routingKeyPrefix;
    }

    public void setRoutingKeyPrefix(String routingKeyPrefix) {
        this.routingKeyPrefix = routingKeyPrefix;
    }

	public Integer getMaxConcurrentConsumers() {
		return maxConcurrentConsumers;
	}

	public void setMaxConcurrentConsumers(Integer maxConcurrentConsumers) {
		this.maxConcurrentConsumers = maxConcurrentConsumers;
	}
    
}