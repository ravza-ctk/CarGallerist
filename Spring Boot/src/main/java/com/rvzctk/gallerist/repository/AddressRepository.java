package com.rvzctk.gallerist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rvzctk.gallerist.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}