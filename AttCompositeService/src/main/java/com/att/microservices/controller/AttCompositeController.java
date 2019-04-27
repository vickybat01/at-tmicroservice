package com.att.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.att.microservices.model.GenericAttOutput;
import com.att.microservices.service.AttCompositeService;

@RestController
@RequestMapping("${spring.application.version}")
public class AttCompositeController {
	
	@Autowired
	AttCompositeService attCompositeService;
	
	
	@RequestMapping(value = "/retrieveInformation", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<GenericAttOutput> retrieveAttMessage(
			@RequestHeader(value = "testHeader") String test)
			throws Exception {
		return new ResponseEntity<>(attCompositeService.retrieveInformation(),
				HttpStatus.OK);
	}

}
