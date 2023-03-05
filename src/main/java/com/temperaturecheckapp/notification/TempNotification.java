package com.temperaturecheckapp.notification;

import com.temperaturecheckapp.model.TempCriteria;

public interface TempNotification {
	void sendNotification(TempCriteria tempCriteria);
}
