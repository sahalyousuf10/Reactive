package com.nisum.springwebflux5.StockTrading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.springwebflux5.StockTrading.dto.StockRequest;
import com.nisum.springwebflux5.StockTrading.dto.StockResponse;
import com.nisum.springwebflux5.StockTrading.service.StocksService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/stocks")
public class StockController {

	@Autowired
	private StocksService stocksService;

	@GetMapping("/{id}")
	public Mono<StockResponse> getOneStock(@PathVariable String id) {
		return stocksService.getOneStock(id);
	}

	@GetMapping
	public Flux<StockResponse> getAllStocks() {
		return stocksService.getAllStock();
	}

	@PostMapping
	public Mono<StockResponse> createStock(@RequestBody StockRequest stock) {
		return stocksService.createStock(stock);
	}

	@PutMapping
	public Mono<StockResponse> updateStock(@RequestBody StockRequest stock) {
		return stocksService.updateStock(stock);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> deleteOneStock(@PathVariable String id) {
		return stocksService.deleteOneStock(id);
	}
}
