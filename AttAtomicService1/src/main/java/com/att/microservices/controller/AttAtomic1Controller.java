package com.att.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.att.microservices.exception.AttAtomicService1Exception;
import com.att.microservices.model.AtomicService1Output;
import com.att.microservices.model.GenericAttOutput;
import com.att.microservices.model.Trader;
import com.att.microservices.service.AttAtomicService1;




@RestController
@RequestMapping("${spring.application.version}")
public class AttAtomic1Controller {
	
	@Autowired
	AttAtomicService1 service;
	
	@RequestMapping(value = "/getTraderInfo", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public AtomicService1Output getMessages1() 
            throws AttAtomicService1Exception
    {
		AtomicService1Output op1 = new AtomicService1Output();
		op1.setTraderList(service.tradersFromCambridge());
		op1.setTraders(service.traderNames());
        return op1;
    }
	
}
