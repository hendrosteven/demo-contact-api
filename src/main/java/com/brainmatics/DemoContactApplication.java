package com.brainmatics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.brainmatics"})
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class}) 
@SpringBootApplication
public class DemoContactApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoContactApplication.class, args);
	}
}
