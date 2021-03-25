package com.mercedes.fuleeventlistner.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mercedes.fuleeventlistner.model.CityFuelPrice;

/**
 * The class calculated the total volume of fuel and gives total cost of the fuel to the user.
 * @author vikash
 *
 */
@Service
public class FuelPriceCalculationService {

	public static final Logger logger = LoggerFactory.getLogger(FuelPriceCalculationService.class);


	/**
	 * This method calculates the fuel price based on tank lid open and close time. 
	 * @param cityFuelPrice
	 */
	public double calculateFuelPrice(CityFuelPrice cityFuelPrice) {

		Double fuelRate = cityFuelPrice.getFuelPrice();
		Double totalCost = calculateFuelVolume(cityFuelPrice) * fuelRate;
		logger.info("You are in {} City and your total fuel cost is {} ", 
				cityFuelPrice.getCityName(), totalCost  );
		return totalCost;
	}

	/**
	 * This method calculates the total volume of fuel filled into the tank assuming 1 litre
	 * of fuel is filled every 30 seconds. 
	 * @param cityFuelPrice
	 */
	private double calculateFuelVolume(CityFuelPrice cityFuelPrice) {
		double volume = (lidOpenTime(cityFuelPrice))/30000;
		logger.info("total volume of fuel disburst : {}" , volume);
		return volume;
	}

	/**
	 * This method calculates the total time from lid opening to lid closing. 
	 * @param cityFuelPrice
	 */
	private double lidOpenTime(CityFuelPrice cityFuelPrice) {		
		double timeInSeconds = cityFuelPrice.getLidCloseTime() - cityFuelPrice.getLidOpenTime();
		logger.info("total lid open time : {} ",timeInSeconds);
		return timeInSeconds;

	}
}
