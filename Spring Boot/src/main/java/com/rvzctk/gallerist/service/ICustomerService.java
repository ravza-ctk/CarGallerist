package com.rvzctk.gallerist.service;

import com.rvzctk.gallerist.dto.DtoCustomer;
import com.rvzctk.gallerist.dto.DtoCustomerIU;

public interface ICustomerService {

    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);
}
