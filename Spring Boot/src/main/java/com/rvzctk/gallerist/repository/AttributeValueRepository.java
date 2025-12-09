package com.rvzctk.gallerist.repository;

import com.rvzctk.gallerist.attribute.Attribute;
import com.rvzctk.gallerist.attribute.AttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface AttributeValueRepository extends JpaRepository<AttributeValue, Long> {

}


