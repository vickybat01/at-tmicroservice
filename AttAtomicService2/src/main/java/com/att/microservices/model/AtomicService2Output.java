package com.att.microservices.model;

import java.io.Serializable;
import java.util.List;

public class AtomicService2Output implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String> uniqueCities;
	private Integer highestTransaction;
	private Integer smallestTransaction;
	public List<String> getUniqueCities() {
		return uniqueCities;
	}
	public void setUniqueCities(List<String> uniqueCities) {
		this.uniqueCities = uniqueCities;
	}
	public Integer getHighestTransaction() {
		return highestTransaction;
	}
	public void setHighestTransaction(Integer highestTransaction) {
		this.highestTransaction = highestTransaction;
	}
	public Integer getSmallestTransaction() {
		return smallestTransaction;
	}
	public void setSmallestTransaction(Integer smallestTransaction) {
		this.smallestTransaction = smallestTransaction;
	}
	@Override
	public String toString() {
		return "AtomicService2Output [uniqueCities=" + uniqueCities
				+ ", highestTransaction=" + highestTransaction
				+ ", smallestTransaction=" + smallestTransaction + "]";
	}

}
