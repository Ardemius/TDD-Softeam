package com.softeam.converttoarab;

import java.util.HashMap;
import java.util.Map;

/**
 * Kata TDD Roman to Arabic numerals converter
 * <p>
 * Some info on the logic of the resulting algo:<br/>
 * for XIV = 14:
 * <ol>
 * <li>X[10] + I[1] = 11</li>
 * <li>X[10] + I[1] + (V[5] - I[1]) - I[1] = 11 + 4 - 1 = 14</li>
 * </ol>
 */
public class RomanToNumeralConverter {
	
	private final static Map<Character, Integer> ROMAN_ARABIC_MAP = new HashMap<>();
	static {
		ROMAN_ARABIC_MAP.put('I', 1);
		ROMAN_ARABIC_MAP.put('V', 5);
		ROMAN_ARABIC_MAP.put('X', 10);
		ROMAN_ARABIC_MAP.put('L', 50);
		ROMAN_ARABIC_MAP.put('C', 100);
		ROMAN_ARABIC_MAP.put('M', 1000);
	}

	public int convert(String roman) {
		int arabicResult = 0;
		int arabicDigitCurrent = 0;
		int arabicDigitPrevious = 0;

		for (int i = 0; i < roman.length(); i++) {
			arabicDigitCurrent = ROMAN_ARABIC_MAP.get(roman.charAt(i));
			
			if (arabicDigitCurrent > arabicDigitPrevious && arabicDigitPrevious != 0) {
				arabicDigitCurrent -= arabicDigitPrevious;
				arabicResult -= arabicDigitPrevious;
			} 
			
			arabicResult += arabicDigitCurrent;
			
			arabicDigitPrevious = arabicDigitCurrent;
		}

		return arabicResult;
	}

}
