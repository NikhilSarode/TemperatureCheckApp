package com.temperaturecheckapp.controller;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.temperaturecheckapp.model.TempCriteria;
import com.temperaturecheckapp.model.User;
import com.temperaturecheckapp.model.UserCriteria;
import com.temperaturecheckapp.service.TemperatureCriteriaService;

@RestController
@RequestMapping(path = "/tempcriteria")
public class TempCriteriaController {
	
	@Autowired
	TemperatureCriteriaService tempCriteriaService;

	//This endpoint creates the new temperature criteria
	@PostMapping
	public UserCriteria createTempCriterias(@RequestBody UserCriteria userCriteria){
		return tempCriteriaService.createTempCriterias(userCriteria);
	}
	
	//This endpoint gives the temperature criterias for all users 
	@GetMapping
	public Map<User, Set<TempCriteria>> getTempCriterias() {
		return tempCriteriaService.getTempCriterias();
	}
}
