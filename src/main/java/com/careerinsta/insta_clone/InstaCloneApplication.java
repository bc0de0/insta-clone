package com.careerinsta.insta_clone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.careerinsta.insta_clone.repository")
public class InstaCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstaCloneApplication.class, args);
	}

}
