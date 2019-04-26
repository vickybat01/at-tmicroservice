package com.att.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages ={"com.att.microservices"})
@EnableAutoConfiguration
@EnableDiscoveryClient
public class AttCompositeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttCompositeServiceApplication.class, args);
	}

}
