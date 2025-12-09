package com.rvzctk.gallerist.service.impl;

import java.util.Date;

import com.rvzctk.gallerist.attribute.AttributeValue;
import com.rvzctk.gallerist.exception.BaseException;
import com.rvzctk.gallerist.exception.ErrorMessage;
import com.rvzctk.gallerist.exception.MessageType;
import com.rvzctk.gallerist.model.Gallerist;
import com.rvzctk.gallerist.repository.AttributeValueRepository;
import com.rvzctk.gallerist.repository.GalleristRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvzctk.gallerist.dto.DtoCar;
import com.rvzctk.gallerist.dto.DtoCarIU;
import com.rvzctk.gallerist.model.Car;
import com.rvzctk.gallerist.repository.CarRepository;
import com.rvzctk.gallerist.service.ICarService;

@Service
public class CarServiceImpl implements ICarService{

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private GalleristRepository galleristRepository;

    @Autowired
    private AttributeValueRepository attributeValueRepository; // Yeni eklenen repository

    private Car createCar(DtoCarIU dtoCarIU) {
        Car car = new Car();
        car.setCreatedDate(new Date());


        BeanUtils.copyProperties(dtoCarIU, car, "currencyTypeId", "carStatusTypeId", "galleristId");


        if (dtoCarIU.getCurrencyTypeId() != null) {
            AttributeValue currency = attributeValueRepository.findById(dtoCarIU.getCurrencyTypeId())
                    .orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, "Currency ID not found")));
            car.setCurrencyType(currency);
        }


        if (dtoCarIU.getCarStatusTypeId() != null) {
            AttributeValue status = attributeValueRepository.findById(dtoCarIU.getCarStatusTypeId())
                    .orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, "Status ID not found")));
            car.setCarStatusType(status);
        }


        if (dtoCarIU.getGalleristId() != null) {
            Gallerist gallerist = galleristRepository.findById(dtoCarIU.getGalleristId())
                    .orElseThrow(() -> new BaseException(
                            new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoCarIU.getGalleristId().toString())));
            car.setGallerist(gallerist);
        }

        return car;
    }

    @Override
    public DtoCar saveCar(DtoCarIU dtoCarIU) {
        DtoCar dtoCar = new DtoCar();

        Car savedCar = carRepository.save(createCar(dtoCarIU));


        BeanUtils.copyProperties(savedCar, dtoCar);



        return dtoCar;
    }


}
