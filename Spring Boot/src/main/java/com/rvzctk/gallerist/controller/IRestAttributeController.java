package com.rvzctk.gallerist.controller;

import com.rvzctk.gallerist.dto.DtoAttribute;
import com.rvzctk.gallerist.dto.DtoAttributeIU;
import com.rvzctk.gallerist.dto.DtoAttributeValue;
import com.rvzctk.gallerist.dto.DtoAttributeValueIU;
import jakarta.validation.Valid;

import java.util.List;

public interface IRestAttributeController {

    RootEntity<DtoAttribute> createAttribute(DtoAttributeIU dto);

    RootEntity<DtoAttributeValue> createAttributeValue(String attrCode, DtoAttributeValueIU dto);

    RootEntity<List<DtoAttributeValue>> getValuesByAttributeCode(String attrCode);
}

