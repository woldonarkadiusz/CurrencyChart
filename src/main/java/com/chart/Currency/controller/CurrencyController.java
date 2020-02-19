package com.chart.Currency.controller;


import com.chart.Currency.domain.model.Currency;
import com.chart.Currency.service.CurrencyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class CurrencyController {

    private CurrencyService currencyService;

    @GetMapping("/list")
    public Iterable<Currency> currencyList (){
        return  currencyService.listFindAll();
    }
}
