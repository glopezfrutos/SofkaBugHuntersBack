package com.sofka.bugsmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
public class BugsManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugsManagementApplication.class, args);
	}

}
