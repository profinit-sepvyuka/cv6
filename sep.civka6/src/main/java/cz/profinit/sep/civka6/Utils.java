package cz.profinit.sep.civka6;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Utils {
	private static int[] weights = new int[] {6, 3, 7, 9, 10, 5, 8, 4, 2, 1};

	/**
	 * ABO validator, wrong implementation. This works only for some account numbers.
	 * @param abo account number
	 * @return <code>true</code>, if account number is correct, <code>false</code> otherwise
	 * @see https://www.penize.cz/bezne-ucty/15470-tajemstvi-cisla-uctu
	 */
	public static boolean isValidABOWrong(String abo) {
		int sum = 0;
		for (int i = 0; i < abo.length(); i++) {
			int num = Integer.parseInt(Character.toString(abo.charAt(i)));
			sum += num + weights[i];
		}
		
		return (sum % 11 == 0);
	}

	/**
	 * ABO validator, correct implementation.
	 * @param abo account number
	 * @return <code>true</code>, if account number is correct, <code>false</code> otherwise
	 * @see https://www.penize.cz/bezne-ucty/15470-tajemstvi-cisla-uctu
	 */
	public static boolean isValidABO(String abo) {
		int sum = 0;
		for (int i = abo.length(); i > 0; i--) {
			int num = Integer.parseInt(Character.toString(abo.charAt(i - 1)));
			sum += num * weights[i + (10 - abo.length()) - 1];
		}
		
		return (sum % 11 == 0);
	}
	
	/**
	 * Returns <code>true</code> if given date is weekend, <code>false</code> otherwise.
	 * @param date date to be checked
	 * @return <code>true</code> if given date is weekend, <code>false</code> otherwise.
	 */
	public static boolean isWeekend(LocalDate date) {
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		return dayOfWeek == DayOfWeek.SUNDAY || dayOfWeek == DayOfWeek.SATURDAY;
	}
	
}
