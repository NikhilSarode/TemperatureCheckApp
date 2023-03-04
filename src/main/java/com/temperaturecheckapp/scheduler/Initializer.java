package com.temperaturecheckapp.scheduler;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*As soon as the spring starts, this will spawn a new thread that acts as a scheduler to check for temperature changes*/
@Component
public class Initializer implements InitializingBean {

	@Autowired
	TemperatureCheckerThread temperatureCheckerThread;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		Thread t=new Thread(temperatureCheckerThread);
		t.start();
	}
}
