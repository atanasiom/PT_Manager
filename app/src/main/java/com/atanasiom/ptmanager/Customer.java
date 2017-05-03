package com.atanasiom.ptmanager;

public class Customer {
	private int picID;
	private String name;
	private String path;

	public Customer(String name, int picID) {
		this.picID = picID;
		this.name = name;
	}

	public Customer(String name, String path) {
		this.path = path;
		this.name = name;
	}

	public int getCustomerImage() {
		return this.picID;
	}

	public String getCustomerImagePath() {
		return this.path;
	}


	public String getName() {
		return this.name;
	}

}