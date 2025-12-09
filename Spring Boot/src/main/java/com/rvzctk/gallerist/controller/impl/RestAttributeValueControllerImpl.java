package com.rvzctk.gallerist.controller.impl;

import com.rvzctk.gallerist.attribute.AttributeValue;
import com.rvzctk.gallerist.controller.IRestAttributeValueController;
import com.rvzctk.gallerist.controller.RestBaseController;
import com.rvzctk.gallerist.controller.RootEntity;
import com.rvzctk.gallerist.dto.DtoAttributeValue;
import com.rvzctk.gallerist.dto.DtoAttributeValueIU;
import com.rvzctk.gallerist.repository.AttributeValueRepository;
import com.rvzctk.gallerist.service.IAttributeValueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/attribute-value")
public class RestAttributeValueControllerImpl extends RestBaseController implements IRestAttributeValueController {


    @Autowired
    private IAttributeValueService attributeValueService;

    @GetMapping("/{id}")
    @Override
    public RootEntity<DtoAttributeValue> getAttributeValueById(@PathVariable Long id) {
        return ok(attributeValueService.getById(id));
    }

    @PutMapping("/update/{id}")
    @Override
    public RootEntity<DtoAttributeValue> updateAttributeValue(@PathVariable Long id, @Valid @RequestBody DtoAttributeValueIU dto) {
        return ok(attributeValueService.update(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public RootEntity<String> deleteAttributeValue(@PathVariable Long id) {
        attributeValueService.delete(id);
        return ok("Özellik değeri başarıyla silindi.");
    }
}
