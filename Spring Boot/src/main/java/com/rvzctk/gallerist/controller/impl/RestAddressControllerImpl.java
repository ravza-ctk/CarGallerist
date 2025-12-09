package com.rvzctk.gallerist.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rvzctk.gallerist.controller.IRestAddressController;
import com.rvzctk.gallerist.controller.RestBaseController;
import com.rvzctk.gallerist.controller.RootEntity;
import com.rvzctk.gallerist.dto.DtoAddress;
import com.rvzctk.gallerist.dto.DtoAddressIU;
import com.rvzctk.gallerist.service.IAddressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/address")
public class RestAddressControllerImpl extends RestBaseController implements IRestAddressController{

    @Autowired
    private IAddressService addressService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoAddress> saveAddress(@Valid @RequestBody DtoAddressIU dtoAddressIU) {
        return ok(addressService.saveAddress(dtoAddressIU));
    }

}
