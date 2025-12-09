package com.rvzctk.gallerist.service.impl;

import java.util.Date;
import java.util.Optional;

import com.rvzctk.gallerist.repository.AttributeRepository;
import com.rvzctk.gallerist.repository.AttributeValueRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvzctk.gallerist.dto.DtoAddress;
import com.rvzctk.gallerist.dto.DtoGallerist;
import com.rvzctk.gallerist.dto.DtoGalleristIU;
import com.rvzctk.gallerist.exception.BaseException;
import com.rvzctk.gallerist.exception.ErrorMessage;
import com.rvzctk.gallerist.exception.MessageType;
import com.rvzctk.gallerist.model.Address;
import com.rvzctk.gallerist.model.Gallerist;
import com.rvzctk.gallerist.repository.AddressRepository;
import com.rvzctk.gallerist.repository.GalleristRepository;
import com.rvzctk.gallerist.service.IGalleristService;

@Service
public class GalleristServiceImpl implements IGalleristService {

    @Autowired
    private GalleristRepository galleristRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AttributeValueRepository attributeValueRepository;

    private Gallerist createGallerist(DtoGalleristIU dtoGalleristIU) {

        Optional<Address> optAddress = addressRepository.findById(dtoGalleristIU.getAddressId());
        if (optAddress.isEmpty()) {
            throw new BaseException(
                    new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoGalleristIU.getAddressId().toString()));
        }

        Gallerist gallerist = new Gallerist();
        gallerist.setCreatedDate(new Date());

        BeanUtils.copyProperties(dtoGalleristIU, gallerist);
        gallerist.setAddress(optAddress.get());

        return gallerist;

    }

    @Override
    public DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU) {
        DtoGallerist dtoGallerist = new DtoGallerist();
        DtoAddress dtoAddress = new DtoAddress();

        Gallerist savedGallerist = galleristRepository.save(createGallerist(dtoGalleristIU));

        BeanUtils.copyProperties(savedGallerist, dtoGallerist);
        BeanUtils.copyProperties(savedGallerist.getAddress(), dtoAddress);

        dtoGallerist.setAddress(dtoAddress);
        return dtoGallerist;
    }

}