package com.chart.Currency.domain.repository;

import com.chart.Currency.domain.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository <Currency, Integer> {
}
