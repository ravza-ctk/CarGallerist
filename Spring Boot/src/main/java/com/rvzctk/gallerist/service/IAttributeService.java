package com.rvzctk.gallerist.service;

import com.rvzctk.gallerist.dto.DtoAttribute;
import com.rvzctk.gallerist.dto.DtoAttributeIU;
import com.rvzctk.gallerist.dto.DtoAttributeValue;
import com.rvzctk.gallerist.dto.DtoAttributeValueIU;

import java.util.List;

public interface IAttributeService {

    DtoAttribute createAttribute(DtoAttributeIU dto);

    DtoAttributeValue createAttributeValue(String attrCode, DtoAttributeValueIU dto);

    List<DtoAttributeValue> getValuesByAttributeCode(String attrCode);
}
