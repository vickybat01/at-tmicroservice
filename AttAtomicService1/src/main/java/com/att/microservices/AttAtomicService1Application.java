package com.att.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages ={"com.att.microservices"})
public class AttAtomicService1Application {

	public static void main(String[] args) {
		SpringApplication.run(AttAtomicService1Application.class, args);
	}

}
