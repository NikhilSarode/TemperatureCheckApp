package com.temperaturecheckapp.scheduler;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.temperaturecheckapp.data.Data;
import com.temperaturecheckapp.model.TempCriteria;
import com.temperaturecheckapp.notification.TempNotification;
import com.temperaturecheckapp.source.TemperatureSource;
import com.temperaturecheckapp.util.Util;

@Component
public class TemperatureCheckerThread implements Runnable{
	
	@Autowired
	@Qualifier("websocketnotification")
	private TempNotification tempNotification;
	
	@Autowired
	@Qualifier("randomtempgenerator")
	private TemperatureSource temperatureSource;
	
	/*The job of this thread is to check whether there are any cities that has crossed the temperatures
	If yes then send the notification to the subscribers*/
	@Override
	public void run() {
		while(true) {
			try {Thread.sleep(3000);} catch (InterruptedException e) {}
			Set<TempCriteria> criteriaSet= Data.getInstance().getTempCriteriasSet();
			for(TempCriteria tempCri:criteriaSet) {
				float cityTemp=temperatureSource.getTemperature(tempCri.getCity());
				if(cityTemp>tempCri.getTemperature()) {
					//send notification
					tempNotification.sendNotification(tempCri);
				}
			}
		}
	}
	
}
