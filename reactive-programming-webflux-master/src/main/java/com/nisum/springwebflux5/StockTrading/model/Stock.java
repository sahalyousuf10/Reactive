package com.nisum.springwebflux5.StockTrading.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.nisum.springwebflux5.StockTrading.service.StocksService;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
@Slf4j
public class Stock {

	@Id
	private String id;
	
	private String name;
	
	@NonNull
	private BigDecimal price;
	
	private String currency;

}
