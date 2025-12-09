package com.rvzctk.gallerist.service.impl;

import com.rvzctk.gallerist.attribute.Attribute;
import com.rvzctk.gallerist.attribute.AttributeValue;
import com.rvzctk.gallerist.dto.DtoAttribute;
import com.rvzctk.gallerist.dto.DtoAttributeIU;
import com.rvzctk.gallerist.dto.DtoAttributeValue;
import com.rvzctk.gallerist.dto.DtoAttributeValueIU;
import com.rvzctk.gallerist.repository.AttributeRepository;
import com.rvzctk.gallerist.repository.AttributeValueRepository;
import com.rvzctk.gallerist.service.IAttributeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AttributeServiceImpl implements IAttributeService {
    @Autowired
    private AttributeRepository attributeRepository;

    @Autowired
    private AttributeValueRepository attributeValueRepository;

    @Override
    public DtoAttribute createAttribute(DtoAttributeIU dto) {
        Attribute attr = new Attribute();
        attr.setCode(dto.getCode());
        attr.setName(dto.getName());

        Attribute savedAttr = attributeRepository.save(attr);

        // Entity -> DTO Çevrimi
        DtoAttribute response = new DtoAttribute();
        response.setId(savedAttr.getId());
        response.setName(savedAttr.getName());
        // response.setCode(savedAttr.getCode()); // DtoAttribute'da code alanı varsa açın
        return response;
    }

    @Override
    public DtoAttributeValue createAttributeValue(String attrCode, DtoAttributeValueIU dto) {
        Optional<Attribute> attrOpt = attributeRepository.findByCode(attrCode);
        if (attrOpt.isEmpty()) {
            // Özel Exception yapınız varsa onu fırlatın, yoksa RuntimeException
            throw new RuntimeException("Attribute bulunamadı: " + attrCode);
        }

        AttributeValue val = new AttributeValue();
        val.setValue(dto.getValue());
        val.setAttribute(attrOpt.get());

        AttributeValue savedVal = attributeValueRepository.save(val);

        // Entity -> DTO Çevrimi
        DtoAttributeValue response = new DtoAttributeValue();
        response.setId(savedVal.getId());
        response.setValue(savedVal.getValue());
        return response;
    }

    @Override
    public List<DtoAttributeValue> getValuesByAttributeCode(String attrCode) {
        Optional<Attribute> attrOpt = attributeRepository.findByCode(attrCode);
        if (attrOpt.isEmpty()) {
            throw new RuntimeException("Attribute bulunamadı: " + attrCode);
        }

        List<AttributeValue> values = attrOpt.get().getValues();
        List<DtoAttributeValue> responseList = new ArrayList<>();

        for (AttributeValue val : values) {
            DtoAttributeValue dto = new DtoAttributeValue();
            dto.setId(val.getId());
            dto.setValue(val.getValue());
            responseList.add(dto);
        }
        return responseList;
    }
}