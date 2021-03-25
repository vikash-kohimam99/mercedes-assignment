package com.mercedes.fuleservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercedes.fuleservice.model.FuelConfig;

@Repository
public interface CityFuelPriceRepository extends JpaRepository<FuelConfig, Long>{
	
}

