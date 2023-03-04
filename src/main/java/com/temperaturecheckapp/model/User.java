package com.temperaturecheckapp.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User{
	@JsonProperty("userName")
	private String userName;
	
	public User(@JsonProperty("userName") String userName) {
		super();
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userName);
	}

	@Override
	public boolean equals(Object obj) {
		return userName.equals(((User)obj).getUserName());
	}
	
	@Override
	public String toString() {
		return userName;
	}
	
	
	
	
}
