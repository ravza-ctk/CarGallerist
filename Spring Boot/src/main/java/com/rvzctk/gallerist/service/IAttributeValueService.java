package com.rvzctk.gallerist.service;

import com.rvzctk.gallerist.dto.DtoAttributeValue;
import com.rvzctk.gallerist.dto.DtoAttributeValueIU;

import java.util.List;

public interface IAttributeValueService {

    DtoAttributeValue getById(Long id);

    DtoAttributeValue update(Long id, DtoAttributeValueIU dto);

    void delete(Long id);
}