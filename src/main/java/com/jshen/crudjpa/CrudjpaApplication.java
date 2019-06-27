package com.jshen.crudjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com")
public class CrudjpaApplication extends SpringBootServletInitializer {

	@Override protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CrudjpaApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CrudjpaApplication.class, args);
	}

}
