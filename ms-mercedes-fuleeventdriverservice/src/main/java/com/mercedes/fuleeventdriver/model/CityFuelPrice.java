package com.mercedes.fuleeventdriver.model;

public class CityFuelPrice {
		private Long cityId;
		private String cityName;
		private String fuelPrice;
		private Boolean lidStatus;
		private Long lidOpenTime;
		private Long LidCloseTime;
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
		public Boolean getLidStatus() {
			return lidStatus;
		}
		public void setLidStatus(Boolean lidStatus) {
			this.lidStatus = lidStatus;
		}
		public Long getLidOpenTime() {
			return lidOpenTime;
		}
		public void setLidOpenTime(Long lidOpenTime) {
			this.lidOpenTime = lidOpenTime;
		}
		public Long getLidCloseTime() {
			return LidCloseTime;
		}
		public void setLidCloseTime(Long lidCloseTime) {
			LidCloseTime = lidCloseTime;
		}
		@Override
		public String toString() {
			return "CityFuelPrice [cityId=" + cityId + ", cityName=" + cityName + ", fuelPrice=" + fuelPrice
					+ ", lidStatus=" + lidStatus + ", lidOpenTime=" + lidOpenTime + ", LidCloseTime=" + LidCloseTime
					+ "]";
		}		

	}


