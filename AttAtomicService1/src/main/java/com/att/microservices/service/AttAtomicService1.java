package com.att.microservices.service;

import com.att.microservices.exception.AttAtomicService1Exception;
import com.att.microservices.model.GenericAttOutput;

public interface AttAtomicService1 {
	
	public GenericAttOutput getMessages1() throws AttAtomicService1Exception;

}
