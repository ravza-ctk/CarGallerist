package com.rvzctk.gallerist.controller;

import com.rvzctk.gallerist.dto.DtoAddress;
import com.rvzctk.gallerist.dto.DtoAddressIU;

public interface IRestAddressController {

    public RootEntity<DtoAddress> saveAddress(DtoAddressIU dtoAddressIU);
}
