package com.rvzctk.gallerist.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rvzctk.gallerist.controller.IRestCustomerController;
import com.rvzctk.gallerist.controller.RestBaseController;
import com.rvzctk.gallerist.controller.RootEntity;
import com.rvzctk.gallerist.dto.DtoCustomer;
import com.rvzctk.gallerist.dto.DtoCustomerIU;
import com.rvzctk.gallerist.service.ICustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/customer")
public class RestCustomerControllerImpl extends RestBaseController implements IRestCustomerController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoCustomer> saveCustomer(@Valid @RequestBody DtoCustomerIU dtoCustomerIU) {
        return ok(customerService.saveCustomer(dtoCustomerIU));
    }

}
