package com.rvzctk.gallerist.controller.impl;

import com.rvzctk.gallerist.controller.IRestAccountController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rvzctk.gallerist.controller.RestBaseController;
import com.rvzctk.gallerist.controller.RootEntity;
import com.rvzctk.gallerist.dto.DtoAccount;
import com.rvzctk.gallerist.dto.DtoAccountIU;
import com.rvzctk.gallerist.service.IAccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/account")
public class RestAccountControllerImpl extends RestBaseController implements IRestAccountController {

    @Autowired
    private IAccountService accountService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoAccount> saveAccount(@Valid @RequestBody DtoAccountIU dtoAccountIU) {
        return ok(accountService.saveAccount(dtoAccountIU));
    }

}
