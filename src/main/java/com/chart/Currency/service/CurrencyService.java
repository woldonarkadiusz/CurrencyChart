package com.chart.Currency.service;


import com.chart.Currency.domain.model.Currency;
import com.chart.Currency.domain.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    public Currency currencySave (Currency currency){
        return currencyRepository.save(currency);
    }

    public List<Currency> currencyFromJason (Map<String, String> currencyMap) {
        List <Currency> list =  new ArrayList<>();
        for (Map.Entry<String, String> entrySet : currencyMap.entrySet()) {
            Currency currency = new Currency();
            currency.setCurrencyShortName(entrySet.getKey());
            currency.setCurrencyLongName(entrySet.getValue());
            list.add(currency);
        }
        return list;
    }

    public Iterable<Currency> currencyListSave(List<Currency> currencyList) {
       return currencyRepository.saveAll(currencyList);
    }

    public Iterable<Currency> listFindAll (){
        return  currencyRepository.findAll();
    }

}
