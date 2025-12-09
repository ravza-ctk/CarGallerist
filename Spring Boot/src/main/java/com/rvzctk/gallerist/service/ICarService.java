package com.rvzctk.gallerist.service;

import com.rvzctk.gallerist.dto.DtoCar;
import com.rvzctk.gallerist.dto.DtoCarIU;

public interface ICarService {

    public DtoCar saveCar(DtoCarIU dtoCarIU);
}
