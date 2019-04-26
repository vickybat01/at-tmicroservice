package com.att.microservices.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.att.microservices.model.GenericAttOutput;
import com.att.microservices.service.AttCompositeService;

@Service
public class AttCompositeServiceImpl implements AttCompositeService {
	
	@Autowired
	private LoadBalancerClient loadBalancer;

	@Autowired
	Jackson2ObjectMapperBuilder builder;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public List<GenericAttOutput> retrieveMessages() {
		
		return null;
	}

}
