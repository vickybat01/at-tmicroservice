package com.att.microservices.model;

import java.io.Serializable;

public class GenericAttOutput implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AtomicService1Output op1;
	private AtomicService2Output op2;
	public AtomicService1Output getOp1() {
		return op1;
	}
	public void setOp1(AtomicService1Output op1) {
		this.op1 = op1;
	}
	public AtomicService2Output getOp2() {
		return op2;
	}
	public void setOp2(AtomicService2Output op2) {
		this.op2 = op2;
	}
	@Override
	public String toString() {
		return "GenericAttOutput [op1=" + op1 + ", op2=" + op2 + "]";
	}
}

