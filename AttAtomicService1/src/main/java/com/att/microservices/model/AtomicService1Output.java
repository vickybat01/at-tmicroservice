package com.att.microservices.model;

import java.io.Serializable;
import java.util.List;

public class AtomicService1Output implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private List<Trader> traderList;
private String traders;
public List<Trader> getTraderList() {
	return traderList;
}
public void setTraderList(List<Trader> traderList) {
	this.traderList = traderList;
}
public String getTraders() {
	return traders;
}
public void setTraders(String traders) {
	this.traders = traders;
}
@Override
public String toString() {
	return "AtomicService1Output [traderList=" + traderList + ", traders="
			+ traders + "]";
}
}
