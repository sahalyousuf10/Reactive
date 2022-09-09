package com.nisum.springwebflux5.StockTrading.exception;

public class StockCreationException extends RuntimeException{

	private String message;

	public StockCreationException(String message) {
		super();
		this.message = message;
	}
	
	
	
}
