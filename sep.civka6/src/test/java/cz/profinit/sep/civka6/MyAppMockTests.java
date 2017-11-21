package cz.profinit.sep.civka6;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import cz.profinit.sep.civka6.dao.ObjektDao;
import cz.profinit.sep.civka6.model.ObjektKUlozeni;


public class MyAppMockTests {

	@Mock
	ObjektDao objektDao;
	
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();	
	
	@Before
	public void setupMocks() {
		ArrayList<ObjektKUlozeni> objects = new ArrayList<>();
		objects.add(new ObjektKUlozeni("sourceIban", "targetIban", BigDecimal.ZERO));
		
		when(objektDao.findAll()).thenReturn(objects);
	}
	
	@Test
	public void testMock() {
		Assert.assertEquals(new ObjektKUlozeni("sourceIban", "targetIban", BigDecimal.ZERO), objektDao.findAll().get(0));
	}
	
}
