package com.temporal.paymentProxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.temporal")
@SpringBootApplication
public class PaymentProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentProxyApplication.class, args);
	}

}
