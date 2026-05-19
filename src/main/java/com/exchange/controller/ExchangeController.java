package com.exchange.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.exchange.model.CurrencyExchange;

@RestController
public class ExchangeController {
     @Autowired
	private Environment environment;
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getExchange(@PathVariable String from ,@PathVariable String to) {
		
		CurrencyExchange currencyExchange = new CurrencyExchange(20L,from , to,BigDecimal.valueOf(50));
		String port=environment.getProperty("server.port");
		currencyExchange.setEnvironment(port);
		return currencyExchange;
	}
}
