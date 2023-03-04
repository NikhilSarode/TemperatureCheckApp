package test.temperaturecheckapp.controller;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.temperaturecheckapp.controller.TempCriteriaController;
import com.temperaturecheckapp.model.TempCriteria;
import com.temperaturecheckapp.model.User;
import com.temperaturecheckapp.model.UserCriteria;
import com.temperaturecheckapp.service.TemperatureCriteriaService;

public class TempCriteriaControllerTest {
	
	@InjectMocks
	TempCriteriaController tempCriteriaController;
	
	@Mock
	TemperatureCriteriaService tempCriteriaService;
	
	@Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
	@Test
	public void testGetTempCriterias() {
		Set<TempCriteria> tempCriteriasSet;
		
		Map<User,Set<TempCriteria>> userTempCriteriaMapping;
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
		
		Mockito.when(tempCriteriaService.getTempCriterias()).thenReturn(userTempCriteriaMapping);
		Map<User,Set<TempCriteria>> result=	tempCriteriaController.getTempCriterias();
		assertEquals(userTempCriteriaMapping, result);
	}
	
	@Test
	public void testCreateTempCriterias() {
		UserCriteria userCriteria=new UserCriteria();
		Mockito.when(tempCriteriaService.createTempCriterias(userCriteria)).thenReturn(userCriteria);
		UserCriteria result=tempCriteriaController.createTempCriterias(userCriteria);
		assertEquals(result, userCriteria);
	}
}
