package com.att.microservices.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.att.microservices.exception.AttAtomicService1Exception;
import com.att.microservices.model.GenericAttOutput;
import com.att.microservices.service.AttAtomicService1;

public class AttAtomicService1Impl implements AttAtomicService1{

	@Override
	public GenericAttOutput getMessages1() throws AttAtomicService1Exception {
		List<String> messages = new ArrayList<>();
		messages.add("At&t atomic1 sample message 1");
		messages.add("At&t atomic1 sample message 2");
		messages.add("At&t atomic1 sample message 3");
		messages.add("At&t atomic1 sample message 4");
		
		GenericAttOutput msg = new GenericAttOutput();
		msg.setMessages(messages);
		return msg;
	}

}
