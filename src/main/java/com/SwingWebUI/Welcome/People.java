package com.SwingWebUI.Welcome;

public class People {
	
	private String name;
	private String surName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public People(String name, String surName) {
		super();
		this.name = name;
		this.surName = surName;
	}
	@Override
	public String toString() {
		return String.format("People [name=%s, surName=%s]", name, surName);
	}

}
