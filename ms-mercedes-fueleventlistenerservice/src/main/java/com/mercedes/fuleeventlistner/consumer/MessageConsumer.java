package com.mercedes.fuleeventlistner.consumer;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mercedes.fuleeventlistner.model.CityFuelPrice;
import com.mercedes.fuleeventlistner.services.FuelPriceCalculationService;

@Component
public class MessageConsumer {
	
	@Autowired
	FuelPriceCalculationService fuelPriceService;

	private final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);
	
	@RabbitListener(queues = "mercedes.queue")	
	public void receivedMessage(CityFuelPrice cityFuelPrice) throws InterruptedException {	
		logger.info("inside receivedMessage method");
		logger.info("Message Received  ==> {}" , cityFuelPrice);
		
		if(cityFuelPrice.getLidStatus()) {
			//Mock fuel filling activity by allowing thread to sleep for random time (within 2 minutes)
			Thread.sleep(new Random().nextInt(120000));	
			cityFuelPrice.setLidCloseTime(System.currentTimeMillis());
			fuelPriceService.calculateFuelPrice(cityFuelPrice);	
		}
	}
}
