package com.nisum.springwebflux5.StockTrading.exception;

public class StockNotFoundException extends RuntimeException{

	private String message;

	public StockNotFoundException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
        this.message = msg;
	}
}
