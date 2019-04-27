package com.att.microservices.service;

import java.util.List;

import com.att.microservices.exception.AttAtomicService1Exception;
import com.att.microservices.model.GenericAttOutput;
import com.att.microservices.model.Trader;

public interface AttAtomicService1 {
	
	public GenericAttOutput getMessages1() throws AttAtomicService1Exception;
	public List<Trader> tradersFromCambridge() throws AttAtomicService1Exception;
	public String traderNames()throws AttAtomicService1Exception;

}
