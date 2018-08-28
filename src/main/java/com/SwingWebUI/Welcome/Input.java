package com.SwingWebUI.Welcome;

public class Input {

	private String name;
	private String radiobutton;


	public Input(String name, String radiobutton) {
		super();
		this.name = name;
		this.radiobutton = radiobutton;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRadiobutton() {
		return radiobutton;
	}

	public void setRadiobutton(String radiobutton) {
		this.radiobutton = radiobutton;
	}

	public Input(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Input [name=%s, radiobutton=%s]", name, radiobutton);
	}


	
}