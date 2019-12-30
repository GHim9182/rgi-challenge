package com.rgi.challengeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RGIRunApplication {
	public static void main(String[] args) {
		SpringApplication.run(RGIRunApplication.class, args);
	}
}
