package com.rvzctk.gallerist.controller;

import com.rvzctk.gallerist.dto.DtoCar;
import com.rvzctk.gallerist.dto.DtoCarIU;

public interface IRestCarController {

    public RootEntity<DtoCar> saveCar(DtoCarIU dtoCarIU);
}
