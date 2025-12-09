package com.rvzctk.gallerist.service.impl;



import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvzctk.gallerist.dto.DtoAddress;
import com.rvzctk.gallerist.dto.DtoAddressIU;
import com.rvzctk.gallerist.model.Address;
import com.rvzctk.gallerist.repository.AddressRepository;
import com.rvzctk.gallerist.service.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService{

    @Autowired
    private AddressRepository addressRepository;


    private Address createAddress(DtoAddressIU dtoAddressIU) {
        Address address = new Address();
        address.setCreatedDate(new Date());

        BeanUtils.copyProperties(dtoAddressIU, address);
        return address;
    }

    @Override
    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU) {
        DtoAddress dtoAddress = new DtoAddress();

        Address savedAddress = addressRepository.save(createAddress(dtoAddressIU));
        BeanUtils.copyProperties(savedAddress, dtoAddress);
        return dtoAddress;
    }



}
