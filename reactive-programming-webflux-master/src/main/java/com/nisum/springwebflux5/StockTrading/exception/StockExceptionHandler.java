package com.nisum.springwebflux5.StockTrading.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class StockExceptionHandler {

	@ExceptionHandler(StockNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage handleStockNotFoundException(StockNotFoundException ex) {
		return ErrorMessage.builder()
				.message(ex.getMessage())
				.build();
	}
	
	@ExceptionHandler(StockCreationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleStockCreationException(StockCreationException ex) {
		return ErrorMessage.builder()
				.message(ex.getMessage())
				.build();
	}
}
