package com.temperaturecheckapp.source;

import org.springframework.stereotype.Component;

import com.temperaturecheckapp.util.Util;

@Component("randomtempgenerator")
public class RandomTemperatureGenerator implements TemperatureSource {

	@Override
	public float getTemperature(String city) {
		return Util.getRandomTemperature();//to simulate temperature change
	}
	
}
