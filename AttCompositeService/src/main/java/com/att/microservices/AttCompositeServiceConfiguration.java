package com.att.microservices;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableAsync
public class AttCompositeServiceConfiguration extends WebMvcConfigurerAdapter{
	
	@Bean(name = "threadPoolTaskExecutor")
    public Executor threadPoolTaskExecutor() 
	{
        return new ThreadPoolTaskExecutor();
    }

}
