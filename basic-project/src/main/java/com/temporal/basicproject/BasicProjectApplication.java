package com.temporal.basicproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.temporal")
@SpringBootApplication(scanBasePackages={"com.temporal.activity"})
@EnableFeignClients
public class BasicProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicProjectApplication.class, args);
	}

}
