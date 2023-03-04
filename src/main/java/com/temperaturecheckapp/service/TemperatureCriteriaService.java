package com.temperaturecheckapp.service;

import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.temperaturecheckapp.data.Data;
import com.temperaturecheckapp.model.TempCriteria;
import com.temperaturecheckapp.model.User;
import com.temperaturecheckapp.model.UserCriteria;

@Service
public class TemperatureCriteriaService {
	
	public UserCriteria createTempCriterias(UserCriteria userCriteria) {
		return Data.getInstance().addTempCriteria(userCriteria);
	}
	
	public Map<User, Set<TempCriteria>> getTempCriterias() {
		return Data.getInstance().getTempCriteriaMapping();
	}
}
