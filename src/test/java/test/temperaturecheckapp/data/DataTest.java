package test.temperaturecheckapp.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.temperaturecheckapp.data.Data;
import com.temperaturecheckapp.model.TempCriteria;
import com.temperaturecheckapp.model.User;
import com.temperaturecheckapp.model.UserCriteria;
import com.temperaturecheckapp.service.TemperatureCriteriaService;

public class DataTest {
	@InjectMocks
	Data d;
	
	@Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
	
	@Test
	public void testCreateTempCriterias() {
		assertEquals(1, d.getTempCriteriasSet().size());
		
	}
	
	@Test
	public void testGetTempCriteriaMapping() {
		assertEquals(3, d.getTempCriteriaMapping().size());
	}
	
	@Test
	public void testAddTempCriteria() {
		UserCriteria userCriteria = new UserCriteria();
		User user=new User("User1");
		TempCriteria t=new TempCriteria("Mumbai", 28);
		userCriteria.setTempCriteria(t);userCriteria.setUser(user);
		d.addTempCriteria(userCriteria);
		assertEquals(2, d.getTempCriteriasSet().size());
		
	}
}
