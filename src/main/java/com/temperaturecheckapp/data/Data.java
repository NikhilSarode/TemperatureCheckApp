package com.temperaturecheckapp.data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.temperaturecheckapp.model.TempCriteria;
import com.temperaturecheckapp.model.User;
import com.temperaturecheckapp.model.UserCriteria;

//Made as singleton class to act as virtual DB
public class Data {
	private static Data data;
	
	private Set<TempCriteria> tempCriteriasSet;
	
	private Map<User,Set<TempCriteria>> userTempCriteriaMapping;
	
	private Data() {
		//initialize with dummy data
		tempCriteriasSet=new HashSet<>();
		User user1=new User("User1");
		User user2=new User("User2");
		User user3=new User("User3");
		userTempCriteriaMapping=new HashMap<>();
		userTempCriteriaMapping.put(user1,new HashSet<>());
		userTempCriteriaMapping.put(user2,new HashSet<>());
		userTempCriteriaMapping.put(user3,new HashSet<>());
		
		TempCriteria tc=new TempCriteria("Pune", 25);
		userTempCriteriaMapping.get(user1).add(tc);
		tempCriteriasSet.add(tc);
	}

	public Set<TempCriteria> getTempCriteriasSet() {
		return tempCriteriasSet;
	}
	
	public static Data getInstance() {
		if(data==null) {
			synchronized (Data.class) {	//So that single instance is maintained when multiple threads try to create
				if(data==null) {
					data= new Data();
				}
			}
		}
		return data;
	}
	
	//Add the temperatire criteria for the specific user.
	public UserCriteria addTempCriteria(UserCriteria userCriteria) {
		tempCriteriasSet.add(userCriteria.getTempCriteria());
		userTempCriteriaMapping.get(userCriteria.getUser()).add(userCriteria.getTempCriteria());
		return userCriteria;
	}
	
	public Map<User, Set<TempCriteria>> getTempCriteriaMapping() {
		return userTempCriteriaMapping;
	}
	
}
