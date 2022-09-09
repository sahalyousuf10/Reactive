package com.nisum.springwebflux5.StockTrading.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nisum.springwebflux5.StockTrading.model.Stock;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockResponse {

	private String id;

	@JsonProperty("stockName")
	private String name;

	private BigDecimal price;

	private String currency;

	public static StockResponse fromModel(Stock stock) {
		return StockResponse.builder()
				.id(stock.getId())
				.name(stock.getName())
				.price(stock.getPrice())
				.currency(stock.getCurrency())
				.build();
	}
}
