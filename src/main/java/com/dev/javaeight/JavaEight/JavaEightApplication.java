package com.dev.javaeight.JavaEight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.dev")
@EntityScan("com.dev")
@EnableJpaRepositories("com.dev")
public class JavaEightApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaEightApplication.class, args);
	}

}

