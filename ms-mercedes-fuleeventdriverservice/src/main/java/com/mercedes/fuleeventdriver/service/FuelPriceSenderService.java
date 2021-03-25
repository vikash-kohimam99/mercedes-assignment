package com.mercedes.fuleeventdriver.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.mercedes.fuleeventdriver.facade.CityWiseFuleServiceFacadeImpl;
import com.mercedes.fuleeventdriver.model.CityFuelPrice;
import com.mercedes.fuleeventdriver.utils.ApplicationUtil;

@EnableScheduling
@Service
public class FuelPriceSenderService {

	private static final Logger logger = LoggerFactory.getLogger(FuelPriceSenderService.class);
	@Autowired
	private AmqpTemplate rabbitMqTemplate;

	@Value("${mercedes.rabbitmq.exchange}")
	private String exchange;

	@Value("${mercedes.rabbitmq.routingkey}")
	private String routingkey;	

	@Value("${mercedes.cityid.url}")
	private String url;
	
	@Autowired
	private CityWiseFuleServiceFacadeImpl facade;

	private CityFuelPrice cityFuelPrice = null;
	
	private Boolean lidStatus = false;

	/**
	 * This method changes the lid status to true and then publishes the message to RabbitMq
	 * @param lidStatus1
	 *
	 */
	public void changeLidStatus(Boolean lidStatus1) {
		lidStatus =lidStatus1;
		callFuelPriceService(cityFuelPrice, lidStatus1);
		cityFuelPrice.setLidOpenTime(System.currentTimeMillis());
		send(cityFuelPrice);
	}
	
	/**
	 * This method publishes the message to RabbitMq
	 * @param cityFuelPrice
	 *
	 */
	public void send(CityFuelPrice cityFuelPrice) {		
			logger.debug("city Fuel Price {} ", cityFuelPrice.toString());
			rabbitMqTemplate.convertAndSend(exchange, routingkey, cityFuelPrice);
			logger.info("message sent from event deriver : {}",cityFuelPrice );	

	}

	/**
	 * This method makes a call to facade layer to call a third party API to get the city and fuel price
	 * @param cityFuelPrice1, lidStatus
	 *
	 */
	private CityFuelPrice callFuelPriceService(CityFuelPrice cityFuelPrice1, boolean lidStatus) {
		Integer randomNumber = ApplicationUtil.generateRandomNumbers();
		HttpHeaders httpHeaders = new HttpHeaders();
		cityFuelPrice1 =facade.getFulePriceCityWise(url+randomNumber,
				ApplicationUtil.createRequest(cityFuelPrice, httpHeaders ),CityFuelPrice.class);
		cityFuelPrice = cityFuelPrice1;
		cityFuelPrice.setLidStatus(lidStatus);
		return cityFuelPrice1;
	}
	
	
	/**
	 * This is a scheduled method which runs every 2 minutes. It checks the status of lid, if its false then only it runs
	 * 
	 */
	@Scheduled(fixedDelay = 120000)
	public void scheduleService() {
		if(!lidStatus) {
			logger.info("Running scheduled service");
			callFuelPriceService(cityFuelPrice, lidStatus);
			send(cityFuelPrice);
		}
	}
}
