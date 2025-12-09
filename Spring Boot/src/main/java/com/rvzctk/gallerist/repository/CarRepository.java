package com.rvzctk.gallerist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rvzctk.gallerist.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{

}
