package com.temperaturecheckapp.util;

import java.util.Random;

public class Util {
	public static float getRandomTemperature(){
		Random r =new Random();
		int min=-273,max=100;
		float random = min + r.nextFloat() * (max - min);
		return random;
	}
}
