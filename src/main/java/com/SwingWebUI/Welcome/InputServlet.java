package com.SwingWebUI.Welcome;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class InputServlet {
	private static List<Input> inputs = new ArrayList();
	
	static {
		
	}


	public List<Input> retrieveInputs() {
		return inputs;
	}
	
	public void addInput(Input input) {
		inputs.add(input);
		
	}
	
	public void deleteInput(Input input) {
		inputs.remove(input);
		
	}
	
	public void clearInput(Input input) {
		
		inputs.clear();
	}
	
}