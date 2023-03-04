package test.temperaturecheckapp.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.temperaturecheckapp.util.Util;
//@RunWith(PowerMockRunner.class)
//@PrepareForTest({Util.class})
public class UtilTest {
	
	
	//@Test
	public void testGetRandomTemperature() {
		PowerMockito.mockStatic(Util.class);
		float temp=Util.getRandomTemperature();
		assertTrue(-273<temp && temp<100);
	}
}
