package com.rvzctk.gallerist.controller;

import com.rvzctk.gallerist.dto.DtoAccount;
import com.rvzctk.gallerist.dto.DtoAccountIU;

public interface IRestAccountController {


    public RootEntity<DtoAccount> saveAccount(DtoAccountIU dtoAccountIU);
}
