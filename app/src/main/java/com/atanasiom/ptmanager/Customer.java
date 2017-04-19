package com.atanasiom.ptmanager;

public class Customer {
	private int picID;
	private String name;

	public Customer(String name, int picID) {
		this.picID = picID;
		this.name = name;
	}

	public int getCustomerImage() {
		return this.picID;
	}

	public String getName() {
		return this.name;
	}

}