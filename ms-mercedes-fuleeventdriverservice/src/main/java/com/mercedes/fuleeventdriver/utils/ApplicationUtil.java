package com.mercedes.fuleeventdriver.utils;

import java.util.Random;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class ApplicationUtil {
	
	public static HttpEntity<Object> createRequest(Object obj, HttpHeaders httpHeaders){
		return new HttpEntity<Object>(obj, createHeaderForJson(httpHeaders));
		
	}

	public static HttpHeaders createHeaderForJson(HttpHeaders httpHeaders) {
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.add("ACCEPT", "application/json");
		return httpHeaders;
	}
	
	public static Integer generateRandomNumbers() {
		return new Random().nextInt(15);
	}

}
