package com.rvzctk.gallerist.service;

import com.rvzctk.gallerist.dto.DtoAddress;
import com.rvzctk.gallerist.dto.DtoAddressIU;

public interface IAddressService {

    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU);

}
