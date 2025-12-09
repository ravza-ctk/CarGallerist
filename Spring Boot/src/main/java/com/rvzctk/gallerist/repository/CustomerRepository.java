package com.rvzctk.gallerist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rvzctk.gallerist.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
