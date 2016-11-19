package com.partneration.exception;

import org.springframework.validation.BindingResult;

public class ParametersException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private BindingResult result;
	
	public ParametersException(){
	}
	
	public ParametersException(String message, BindingResult result){
		super();
		this.result = result;
		System.out.println(message);
	}

	public BindingResult getResult() {
		return result;
	}

	public void setResult(BindingResult result) {
		this.result = result;
	}

}
