package com.mercedes.fuleeventdriver.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mercedes.fuleeventdriver.model.CityFuelPrice;

@Component
public class CityWiseFuleServiceFacadeImpl implements CityWiseFuleServiceFacade{
	
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	/**
	 * This method makes a call to third party API (fuelmockerservice here) to get the fuel price based on city
	 * @param url ,createRequest, class1
	 */
	@Override
	public CityFuelPrice getFulePriceCityWise(String url, HttpEntity<Object> createRequest,
			Class<CityFuelPrice> class1) {
		CityFuelPrice cityFuelPrice = null;
		try {
			 cityFuelPrice=	restTemplate.exchange(url, HttpMethod.GET, createRequest, CityFuelPrice.class).getBody();

		} catch (Exception e) {
			e.getMessage();
		}
		return cityFuelPrice;
		
	}

}
