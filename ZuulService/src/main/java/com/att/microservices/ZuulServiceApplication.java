package com.att.microservices;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;


@SpringBootApplication
@ComponentScan("com.att.microservices")
@EnableZuulProxy
@EnableAutoConfiguration
public class ZuulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServiceApplication.class, args);
	}
	@Bean
    public GatewayServicePreFilter gatewayServicePreFilter() {
    return new GatewayServicePreFilter();
    }
	
	
	@Bean
	public ZuulFilter zuulFilter(){
		return new ZuulFilter() {
			@Override
			public String filterType() {
				return "post";
			}

			@Override
			public int filterOrder() {
				return 999999;
			}

			@Override
			public boolean shouldFilter() {
				return true;
			}

			@Override
			public Object run() {
				final List<String> routingDebug = (List<String>) RequestContext.getCurrentContext().get("routingDebug");
				routingDebug.forEach(System.out::println);
				return null;
			}
		};
	}
}
