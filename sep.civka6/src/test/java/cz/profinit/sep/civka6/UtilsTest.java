package cz.profinit.sep.civka6;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import cz.profinit.sep.civka6.Utils;

public class UtilsTest {

	@Test
	public void isAboTest() {
//		assertTrue(Utils.isValidABOWrong("18432071"));
		assertTrue(Utils.isValidABO("18432071"));
		assertTrue(Utils.isValidABO("123457"));
		assertTrue(Utils.isValidABOWrong("123"));
	}
	
	@Test
	public void isWeekendTest() {
		assertTrue(Utils.isWeekend(LocalDate.of(2017, 11, 4)));
		assertFalse(Utils.isWeekend(LocalDate.of(2017, 11, 8)));
		assertFalse(Utils.isWeekend(LocalDate.now()));
	}
	
}
