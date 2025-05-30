package com.ozmenyavuz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.ozmenyavuz"})
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.ozmenyavuz"})
@ComponentScan("com.ozmenyavuz")
public class ExceptionFullApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExceptionFullApplication.class, args);
	}

}
