package com.rvzctk.gallerist.service.impl;

import com.rvzctk.gallerist.attribute.Attribute;
import com.rvzctk.gallerist.attribute.AttributeValue;
import com.rvzctk.gallerist.dto.DtoAttributeValue;
import com.rvzctk.gallerist.dto.DtoAttributeValueIU;
import com.rvzctk.gallerist.repository.AttributeRepository;
import com.rvzctk.gallerist.repository.AttributeValueRepository;
import com.rvzctk.gallerist.service.IAttributeValueService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttributeValueServiceImpl implements IAttributeValueService {

    @Autowired
    private AttributeValueRepository attributeValueRepository;

    @Override
    public DtoAttributeValue getById(Long id) {
        AttributeValue entity = attributeValueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attribute Value bulunamadı: " + id));

        return toDto(entity);
    }

    @Override
    public DtoAttributeValue update(Long id, DtoAttributeValueIU dto) {
        AttributeValue entity = attributeValueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attribute Value bulunamadı: " + id));


        entity.setValue(dto.getValue());

        AttributeValue updatedEntity = attributeValueRepository.save(entity);
        return toDto(updatedEntity);
    }

    @Override
    public void delete(Long id) {
        AttributeValue entity = attributeValueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attribute Value bulunamadı: " + id));

        attributeValueRepository.delete(entity);
    }

    private DtoAttributeValue toDto(AttributeValue entity) {
        DtoAttributeValue dto = new DtoAttributeValue();
        dto.setId(entity.getId());
        dto.setValue(entity.getValue());
        return dto;
    }
}