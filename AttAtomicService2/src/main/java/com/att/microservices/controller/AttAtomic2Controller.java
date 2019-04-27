package com.att.microservices.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.att.microservices.exception.AttAtomicService2Exception;
import com.att.microservices.model.AtomicService2Output;
import com.att.microservices.model.GenericAttOutput;
import com.att.microservices.service.AttAtomicService2;




@RestController
@RequestMapping("${spring.application.version}")
public class AttAtomic2Controller {
	
	@Autowired
	AttAtomicService2 service;
	

	@RequestMapping(value = "/findUniqueCity&TransactionInfo", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public AtomicService2Output getMessages1() 
            throws AttAtomicService2Exception
    {
		AtomicService2Output op2 = new AtomicService2Output();
		op2.setUniqueCities(service.findByUniqueCity());
		op2.setHighestTransaction(service.highestTransaction().get());
		op2.setSmallestTransaction(service.smallestTransaction().get());
		
        return op2;
    }

}
