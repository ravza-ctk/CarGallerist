package com.rvzctk.gallerist.service;

import com.rvzctk.gallerist.dto.DtoAccount;
import com.rvzctk.gallerist.dto.DtoAccountIU;

public interface IAccountService {

    public DtoAccount saveAccount(DtoAccountIU dtoAccountIU);
}
