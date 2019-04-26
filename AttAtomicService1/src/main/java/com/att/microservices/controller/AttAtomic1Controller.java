package com.att.microservices.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.att.microservices.exception.AttAtomicService1Exception;
import com.att.microservices.model.GenericAttOutput;
import com.att.microservices.service.AttAtomicService1;




@RestController
@RequestMapping("${spring.application.version}")
public class AttAtomic1Controller {
	
	@Autowired
	AttAtomicService1 service;
	
	@RequestMapping(value = "/getMessages1", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public GenericAttOutput getMessages1() 
            throws AttAtomicService1Exception
    {
        return service.getMessages1();
    }

}
