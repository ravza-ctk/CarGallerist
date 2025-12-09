package com.rvzctk.gallerist.controller;

import com.rvzctk.gallerist.attribute.AttributeValue;
import com.rvzctk.gallerist.dto.DtoAttributeValue;
import com.rvzctk.gallerist.dto.DtoAttributeValueIU;
import jakarta.validation.Valid;

import java.util.List;

public interface IRestAttributeValueController {
    RootEntity<DtoAttributeValue> getAttributeValueById(Long id);

    RootEntity<DtoAttributeValue> updateAttributeValue(Long id, @Valid DtoAttributeValueIU dto);

    RootEntity<String> deleteAttributeValue(Long id);
}
