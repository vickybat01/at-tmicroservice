package com.att.microservices.service.impl;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.att.microservices.exceptions.AttAtomicService1Exception;
import com.att.microservices.exceptions.AttAtomicService2Exception;
import com.att.microservices.model.GenericAttOutput;
import com.att.microservices.service.AttCompositeService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AttCompositeServiceImpl implements AttCompositeService {
	
	@Autowired
	private LoadBalancerClient loadBalancer;

	@Autowired
	Jackson2ObjectMapperBuilder builder;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Value("${service.atomic.attAtomicService1.versionname}")
	private String attAtomicService1;
	
	@Value("${service.atomic.attAtomicService2.versionname}")
	private String attAtomicService2;
	
	@Override
	public GenericAttOutput retrieveMessages() {
		
		RequestEntity request = null;
		GenericAttOutput output = new GenericAttOutput();
		ObjectMapper mapper = builder.build();
		ResponseEntity<String> response = null;
		try {
			//calling atomic service one
			request = new RequestEntity(HttpMethod.GET,new URI(locateServiceUrl(attAtomicService1,"getMessages1")));
			response = restTemplate.exchange(request, String.class);
			output= mapper.readValue(response.getBody(), GenericAttOutput.class);
		}catch(HttpStatusCodeException hsce) {
				hsce.printStackTrace();
		} catch (URISyntaxException | AttAtomicService1Exception | AttAtomicService2Exception e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output;
		
		
	}
	
	
	private String locateServiceUrl(String serviceId, String target) throws AttAtomicService1Exception,AttAtomicService2Exception {
		
		ServiceInstance instance = loadBalancer.choose(serviceId);
		URI uri = null;
		if(instance == null) {
			if(attAtomicService1.equals(serviceId)) {
				throw new AttAtomicService1Exception();
			}
			if(attAtomicService2.equals(serviceId)) {
				throw new AttAtomicService2Exception();
			}
		}
		uri = instance.getUri();
		String serviceVersion = serviceId.substring(serviceId.indexOf('_')+1).trim();
		return uri.toString() + "/" + serviceVersion + "/" + target;
	}

}
