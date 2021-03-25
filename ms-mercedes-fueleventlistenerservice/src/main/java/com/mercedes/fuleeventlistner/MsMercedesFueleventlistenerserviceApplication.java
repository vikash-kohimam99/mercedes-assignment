package com.mercedes.fuleeventlistner;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

@SpringBootApplication
public class MsMercedesFueleventlistenerserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsMercedesFueleventlistenerserviceApplication.class, args);
	}

	@Bean
	public Jackson2JsonMessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}
}
