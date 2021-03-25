package com.mercedes.fuleservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mercedes.fuleservice.model.FuelConfig;
import com.mercedes.fuleservice.repository.CityFuelPriceRepository;

@RestController
public class CityFuelPriceController {
	
	@Autowired
	private CityFuelPriceRepository fuelrepository;
	
	@GetMapping("/price/{cityId}")
	public Optional<FuelConfig> getFuelPricewithCity(@PathVariable ("cityId") Long cityId) throws Exception {
		return fuelrepository.findById(cityId);
	}

}
