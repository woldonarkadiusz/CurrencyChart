package com.chart.Currency;

import com.chart.Currency.domain.model.Currency;
import com.chart.Currency.service.CurrencyService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.net.URL;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class CurrencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CurrencyService currencyService) {
		return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<Map<String, String>> typeReference = new TypeReference<Map<String, String>>(){};
			URL url = new  URL ("https://openexchangerates.org/api/currencies.json");
			try {
				Map<String, String> currencyMap = mapper.readValue(url,typeReference);
			 	List<Currency> currencyList = currencyService.currencyFromJason(currencyMap);
				currencyService.currencyListSave(currencyList);
				System.out.println("Currency Saved!");
			} catch (IOException e){
				System.out.println("Unable to save Currency: " + e.getMessage());
			}
		};


	}

}
