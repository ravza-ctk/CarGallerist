package com.rvzctk.gallerist.controller;

import com.rvzctk.gallerist.dto.CurrencyRatesResponse;

public interface IRestCurrencyRatesController {

    public RootEntity<CurrencyRatesResponse> getCurrencyRates(String startDate , String endDate);
}
