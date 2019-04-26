package com.att.microservices.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.att.microservices.exception.AttAtomicService2Exception;
import com.att.microservices.model.GenericAttOutput;
import com.att.microservices.service.AttAtomicService2;




@RestController
@RequestMapping("${spring.application.version}")
public class AttAtomic2Controller {
	
	@Autowired
	AttAtomicService2 service;
	
	@RequestMapping(value = "/getMessages2", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public GenericAttOutput getMessages1() 
            throws AttAtomicService2Exception
    {
        return service.getMessages2();
    }

}
