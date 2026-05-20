package com.exchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exchange.model.CurrencyExchange;
import com.exchange.repo.ExchangeRespository;

@Service
public class ExchangeService {

	@Autowired
	private ExchangeRespository exchangeRespository;

	public CurrencyExchange getCurrencyExchangeValue(String from, String to) {
		return exchangeRespository.findByFromAndTo(from, to);
	}

	public CurrencyExchange saveCurrencyExchangeValue(CurrencyExchange currencyExchange) {
		return exchangeRespository.save(currencyExchange);
	}

}
