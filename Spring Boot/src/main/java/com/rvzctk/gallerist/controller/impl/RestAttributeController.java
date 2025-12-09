package com.rvzctk.gallerist.controller.impl;

import com.rvzctk.gallerist.controller.IRestAttributeController;
import com.rvzctk.gallerist.controller.RestBaseController;
import com.rvzctk.gallerist.controller.RootEntity;
import com.rvzctk.gallerist.dto.DtoAttribute;
import com.rvzctk.gallerist.dto.DtoAttributeIU;
import com.rvzctk.gallerist.dto.DtoAttributeValue;
import com.rvzctk.gallerist.dto.DtoAttributeValueIU;
import com.rvzctk.gallerist.service.IAttributeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/attribute")
public class RestAttributeController extends RestBaseController implements IRestAttributeController {


    @Autowired
    private IAttributeService attributeService;

    @PostMapping("/save-attr")
    @Override
    public RootEntity<DtoAttribute> createAttribute(@Valid @RequestBody DtoAttributeIU dto) {
        return ok(attributeService.createAttribute(dto));
    }

    @PostMapping("/{attrCode}/save-value")
    @Override
    public RootEntity<DtoAttributeValue> createAttributeValue(
            @PathVariable String attrCode,
            @Valid @RequestBody DtoAttributeValueIU dto) {
        return ok(attributeService.createAttributeValue(attrCode, dto));
    }

    @GetMapping("/{attrCode}/values")
    @Override
    public RootEntity<List<DtoAttributeValue>> getValuesByAttributeCode(@PathVariable String attrCode) {
        return ok(attributeService.getValuesByAttributeCode(attrCode));
    }
}
