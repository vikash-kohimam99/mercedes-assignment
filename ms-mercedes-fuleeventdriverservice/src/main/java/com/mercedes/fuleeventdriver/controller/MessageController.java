package com.mercedes.fuleeventdriver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mercedes.fuleeventdriver.service.FuelPriceSenderService;
/**
 * The RestController class to trigger Fuel lid to open or close .
 * @author vikash
 *
 */
@RestController
@RequestMapping("/api")
public class MessageController {

	@Autowired
	FuelPriceSenderService fuelPriceSenderService;

	/**
	 * The GET method - accepts a boolean param lidStatus to trigger lid open or close.
	 * @param lidStatus
	 *
	 */
	@GetMapping(value = "/triggerlid", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = 
		{MediaType.APPLICATION_JSON_VALUE})
	public String triggerFuelLid(@RequestParam(value = "lidStatus", required = true) Boolean lidStatus) {
		fuelPriceSenderService.changeLidStatus(lidStatus);
		return "processed successfully";

	}
}
