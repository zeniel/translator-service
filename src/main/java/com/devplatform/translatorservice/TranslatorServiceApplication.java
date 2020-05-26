package com.devplatform.translatorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TranslatorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TranslatorServiceApplication.class, args);
	}

}
