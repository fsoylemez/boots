package com.accenture.boots;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
/*@Configuration
@EnableAutoConfiguration  // Sprint Boot Auto Configuration
@ComponentScan({"com.accenture.dao","com.accenture.controller"})*/
@ComponentScan(basePackages="com.accenture")
@EnableJpaRepositories(basePackages="com.accenture.dao")
@EntityScan(basePackages="com.accenture.model")
public class BootsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootsApplication.class, args);
	}
}
