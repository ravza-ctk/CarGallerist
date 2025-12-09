package com.rvzctk.gallerist.controller;

import com.rvzctk.gallerist.dto.DtoCustomer;
import com.rvzctk.gallerist.dto.DtoCustomerIU;

public interface IRestCustomerController {

    public RootEntity<DtoCustomer> saveCustomer(DtoCustomerIU dtoCustomerIU);
}
