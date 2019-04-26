package com.att.microservices.service;

import com.att.microservices.exception.AttAtomicService2Exception;
import com.att.microservices.model.GenericAttOutput;

public interface AttAtomicService2 {
	public GenericAttOutput getMessages2() throws AttAtomicService2Exception;
}
