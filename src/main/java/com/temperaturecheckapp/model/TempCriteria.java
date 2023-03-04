package com.temperaturecheckapp.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TempCriteria {
	@JsonProperty("city")
	private String city;
	@JsonProperty("temperature")
	private float temperature;
	
	
	
	public TempCriteria(@JsonProperty("city") String city, @JsonProperty("temperature") float temperature) {
		super();
		this.city = city;
		this.temperature = temperature;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	@Override
	public int hashCode() {
		return Objects.hash(city, temperature);
	}
	@Override
	public boolean equals(Object obj) {
		TempCriteria temp=(TempCriteria) obj;
		if(city.equals(temp.getCity()) && temperature==temp.getTemperature())
			return true;
		return false;
	}
	
	
	
	
}
