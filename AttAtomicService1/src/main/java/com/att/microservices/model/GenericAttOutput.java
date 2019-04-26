package com.att.microservices.model;

import java.util.List;

public class GenericAttOutput {
	
	private List<String> messages;

	@Override
	public String toString() {
		return "GenericAttOutput [messages=" + messages + "]";
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

}
