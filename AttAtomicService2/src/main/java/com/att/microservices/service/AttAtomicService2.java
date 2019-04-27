package com.att.microservices.service;

import java.util.List;
import java.util.Optional;

import com.att.microservices.exception.AttAtomicService2Exception;
import com.att.microservices.model.GenericAttOutput;

public interface AttAtomicService2 {
	public GenericAttOutput getMessages2() throws AttAtomicService2Exception;
	public List<String> findByUniqueCity() throws AttAtomicService2Exception;
	public Optional<Integer> highestTransaction() throws AttAtomicService2Exception;
	public Optional<Integer> smallestTransaction() throws AttAtomicService2Exception;
}
