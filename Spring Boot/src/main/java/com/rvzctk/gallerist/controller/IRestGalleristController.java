package com.rvzctk.gallerist.controller;

import com.rvzctk.gallerist.dto.DtoGallerist;
import com.rvzctk.gallerist.dto.DtoGalleristIU;

public interface IRestGalleristController {

    public RootEntity<DtoGallerist> saveGallerist(DtoGalleristIU dtoGalleristIU);
}
