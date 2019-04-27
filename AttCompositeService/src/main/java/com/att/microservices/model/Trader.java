/**
 * 
 */
package com.att.microservices.model;

import java.io.Serializable;

/**
 * @author vickybat
 *
 */
public class Trader implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String city;

	public Trader() {

	}
	
	public Trader(String name, String city) {
		this.name = name;
		this.city = city;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Trader:"+this.name+ " in " + this.city;
	}
	
	

}
