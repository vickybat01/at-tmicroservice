package com.att.microservices.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.att.microservices.exception.AttAtomicService1Exception;
import com.att.microservices.model.GenericAttOutput;
import com.att.microservices.model.Trader;
import com.att.microservices.model.Transaction;
import com.att.microservices.service.AttAtomicService1;

@Service
public class AttAtomicService1Impl implements AttAtomicService1{
	
	 Trader raoul = new Trader("Raoul", "Cambridge");
	 Trader mario = new Trader("Mario", "Milan");
	 Trader alan = new Trader("Alan", "Cambridge");
	 Trader brian = new Trader("Brian", "Cambridge");

	 List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011,
			300), new Transaction(raoul, 2012, 1000), new Transaction(raoul,
			2011, 400), new Transaction(mario, 2012, 710), new Transaction(
			mario, 2012, 700), new Transaction(alan, 2012, 950));
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
	@Override
	public List<Trader> tradersFromCambridge() throws AttAtomicService1Exception {
		return transactions.stream()
				.map(Transaction::getTrader)
				.filter(trader->trader.getCity().equals("Cambridge"))
				.distinct()
				.sorted(Comparator.comparing(Trader::getName))
				.collect(Collectors.toList());
	}
	@Override
	public String traderNames() throws AttAtomicService1Exception{
		return transactions.stream()
				.map(Transaction::getTrader)
				.map(trader->trader.getName())
				.distinct()
				.sorted()
				.reduce("", (n1,n2)->n1+n2);
	}

}
