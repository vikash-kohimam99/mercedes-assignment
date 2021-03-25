package com.mercedes.fuleservice.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FuelConfig implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long cityId;
	private String cityName;
	private String fuelPrice;
	
	public FuelConfig() {
		//default constructor
	}
	
	public FuelConfig(Long cityId, String cityName, String fuelPrice) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.fuelPrice = fuelPrice;
	}
	
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getFuelPrice() {
		return fuelPrice;
	}
	public void setFuelPrice(String fuelPrice) {
		this.fuelPrice = fuelPrice;
	}
	

}
