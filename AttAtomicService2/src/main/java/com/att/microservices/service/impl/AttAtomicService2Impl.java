package com.att.microservices.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.att.microservices.exception.AttAtomicService2Exception;
import com.att.microservices.model.GenericAttOutput;
import com.att.microservices.service.AttAtomicService2;

public class AttAtomicService2Impl implements AttAtomicService2 {

	@Override
	public GenericAttOutput getMessages2() throws AttAtomicService2Exception {
		List<String> messages = new ArrayList<>();
		messages.add("At&t atomic2 sample message 1");
		messages.add("At&t atomic2 sample message 2");
		messages.add("At&t atomic2 sample message 3");
		messages.add("At&t atomic2 sample message 4");
		
		GenericAttOutput msg = new GenericAttOutput();
		msg.setMessages(messages);
		return msg;
	}

}
