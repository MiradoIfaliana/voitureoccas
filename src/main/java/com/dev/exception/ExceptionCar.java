package com.dev.exception;

public class ExceptionCar  extends Exception {
	String message;
	public ExceptionCar(){}
	public ExceptionCar(String message){
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
