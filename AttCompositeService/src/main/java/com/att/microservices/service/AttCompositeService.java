package com.att.microservices.service;

import java.util.List;

import com.att.microservices.model.GenericAttOutput;

public interface AttCompositeService {
	
	public List<GenericAttOutput> retrieveMessages();

}
