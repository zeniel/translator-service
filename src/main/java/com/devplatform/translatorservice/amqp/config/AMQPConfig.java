package com.devplatform.translatorservice.amqp.config;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
public class AMQPConfig {
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	@Autowired
	private RabbitMQProperties rabbitMQProperties;

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
      SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
      factory.setConnectionFactory(connectionFactory);
      factory.setMaxConcurrentConsumers(rabbitMQProperties.getMaxConcurrentConsumers());
      factory.setMessageConverter(new Jackson2JsonMessageConverter());
      return factory;
    }	
	
}
