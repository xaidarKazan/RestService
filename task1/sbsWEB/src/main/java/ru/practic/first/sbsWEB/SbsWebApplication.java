package ru.practic.first.sbsWEB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:database.properties")
public class SbsWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbsWebApplication.class, args);
	}

}