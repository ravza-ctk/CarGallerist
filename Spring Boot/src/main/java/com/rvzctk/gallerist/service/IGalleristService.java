package com.rvzctk.gallerist.service;


import com.rvzctk.gallerist.dto.DtoGallerist;
import com.rvzctk.gallerist.dto.DtoGalleristIU;

public interface IGalleristService {

    public DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU);
}
