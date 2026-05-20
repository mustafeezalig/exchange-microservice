package com.exchange.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exchange.model.CurrencyExchange;

public interface ExchangeRespository extends JpaRepository<CurrencyExchange, Long>{

	public CurrencyExchange findByFromAndTo(String from , String to);
	
}
