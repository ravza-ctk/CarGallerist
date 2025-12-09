package com.rvzctk.gallerist.service;

import com.rvzctk.gallerist.dto.CurrencyRatesResponse;

public interface ICurrencyRatesService {

    public CurrencyRatesResponse getCurrencyRates(String startDate , String endDate);
}
