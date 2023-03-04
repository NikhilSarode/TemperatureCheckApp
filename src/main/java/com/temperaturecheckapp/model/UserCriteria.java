package com.temperaturecheckapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserCriteria {
	
	@JsonProperty("user")
	private User user;
	
	@JsonProperty("tempCriteria")
	private TempCriteria tempCriteria;
	
	public UserCriteria() {
		super();
	}
	public UserCriteria(@JsonProperty("user") User user,@JsonProperty("tempCriteria") TempCriteria tempCriteria) {
		super();
		this.user = user;
		this.tempCriteria = tempCriteria;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public TempCriteria getTempCriteria() {
		return tempCriteria;
	}
	public void setTempCriteria(TempCriteria tempCriteria) {
		this.tempCriteria = tempCriteria;
	}
	
	
}
