package com.mercedes.fuleeventdriver.facade;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;

import com.mercedes.fuleeventdriver.model.CityFuelPrice;

@Component
public interface CityWiseFuleServiceFacade {


	CityFuelPrice getFulePriceCityWise(String url, HttpEntity<Object> createRequest, Class<CityFuelPrice> class1);
}
