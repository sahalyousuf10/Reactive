package com.nisum.springwebflux5.StockTrading.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.nisum.springwebflux5.StockTrading.dto.StockRequest;
import com.nisum.springwebflux5.StockTrading.dto.StockResponse;
import com.nisum.springwebflux5.StockTrading.exception.StockNotFoundException;
import com.nisum.springwebflux5.StockTrading.repository.StocksRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class StocksService {

	@Autowired
	private StocksRepository stockRepository;

	public Mono<StockResponse> getOneStock(String id) {
		return stockRepository.findById(id).map(StockResponse::fromModel)
				.switchIfEmpty(Mono.error(new StockNotFoundException(
						"Stock not found with id :" + id)))
				.doFirst(()->log.info("Retrieve stock with id : {} ", id))
				.doOnNext(stock->log.info("Stock Found: {}", stock))
				.doOnError(ex->log.info("Something went wrong"))
				.doOnTerminate(()->log.info("Final stock retrieve "))
				.doFinally(signalType-> log.info("Final Done with stock", signalType));
	}

	public Flux<StockResponse> getAllStock() {
		return stockRepository.findAll().map(StockResponse::fromModel);
	}

	public Mono<StockResponse> createStock(StockRequest stockRequest) {
		return Mono.just(stockRequest)
				.map(StockRequest::toModel)
				.flatMap(stock-> stockRepository.save(stock))
				.map(StockResponse::fromModel)
				.onErrorReturn(StockResponse.builder().build());
	}

	
	public Mono<Void> deleteOneStock(String id) {
		return stockRepository.deleteById(id)
				.switchIfEmpty(Mono.error(new StockNotFoundException(
						"Stock not found with id :" + id)));
	}

	public Mono<StockResponse> updateStock(StockRequest stockRequest) {
		// TODO Auto-generated method stub
	   return Mono.just(stockRequest)
				.map(StockRequest::toModel)
				.flatMap(stock-> stockRepository.save(stock))
				.map(StockResponse::fromModel)
				.onErrorReturn(StockResponse.builder().build());
	}

}
