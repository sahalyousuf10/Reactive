package com.nisum.springwebflux5.StockTrading.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nisum.springwebflux5.StockTrading.model.Stock;

public interface StocksRepository extends ReactiveMongoRepository<Stock, String> {

}
