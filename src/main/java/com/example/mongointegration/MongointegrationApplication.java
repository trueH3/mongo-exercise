package com.example.mongointegration;

import io.mongock.runner.springboot.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMongock
public class MongointegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongointegrationApplication.class, args);
	}

}
