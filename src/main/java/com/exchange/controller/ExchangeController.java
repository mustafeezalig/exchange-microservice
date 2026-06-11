package com.exchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exchange.model.CurrencyExchange;
import com.exchange.service.ExchangeService;

@RestController
@RequestMapping("/api")
public class ExchangeController {
	@Autowired
	private ExchangeService exchangeService;
	@Autowired
	private Environment environment;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getExchange(@PathVariable String from, @PathVariable String to) {

		CurrencyExchange currencyExchange = exchangeService.getCurrencyExchangeValue(from, to);
		String port = environment.getProperty("server.port");
		currencyExchange.setEnv(port);
		return currencyExchange;
	}

	@PostMapping("/save/exchange")
	public CurrencyExchange saveExchange(@RequestBody CurrencyExchange currencyExchange) {

		CurrencyExchange currencyExchangeSaved = exchangeService.saveCurrencyExchangeValue(currencyExchange);
		return currencyExchangeSaved;
	}
}
