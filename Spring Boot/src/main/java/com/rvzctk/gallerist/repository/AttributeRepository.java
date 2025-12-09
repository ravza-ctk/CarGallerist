package com.rvzctk.gallerist.repository;

import com.rvzctk.gallerist.attribute.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttributeRepository extends JpaRepository<Attribute, Long> {
        Optional<Attribute> findByCode(String code);


}
