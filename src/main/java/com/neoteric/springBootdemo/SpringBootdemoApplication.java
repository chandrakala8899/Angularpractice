package com.neoteric.springBootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.neoteric.springBootdemo")
public class SpringBootdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootdemoApplication.class, args);
	}

}
