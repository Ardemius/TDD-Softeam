package com.softeam.converttoarab;

import java.util.HashMap;
import java.util.Map;

/**
 * Kata TDD Roman to Arabic numerals converter
 * <p>
 * Some info on the logic of the resulting algo.<br/>
 * for XIV = 14, on an iterative point of view:
 * <ol>
 * <li>First step is 'X', meaning 10</li>
 * <li>Then 'XI', meaning 11</li>
 * <li>Then 'XIV' for 14, meaning we have to go from 11 to 14.<br/>
 * On a grammatical, logical point of view, 14 should be 10 + 4.<br/>
 * Our first 11 should be a 10, implying a "minus 1".<br/>
 * Then we should add 4 ('IV') and not 5 ('V'), meaning another "minus 1".
 * </li>
 * <li>So, at final, on an iterative, programmatic point of view, 'XIV' is:<br/>
 * X[10] + I[1] - I[1] + V[5] - I[1] = 11 - 1 + 5 - 1 = 14
 * </li>
 * </ol>
 */
public class RomanToNumeralConverter {

   private static final Map<Character, Integer> ROMAN_ARABIC_MAP = new HashMap<>();

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
      int arabicResultPrevious = 0;
      int arabicResultCurrent = 0;

      for (int i = 0; i < roman.length(); i++) {
         arabicResultCurrent = ROMAN_ARABIC_MAP.get(roman.charAt(i));
         if (arabicResultCurrent > arabicResultPrevious) {
            arabicResult = arabicResult + arabicResultCurrent - 2 * arabicResultPrevious;
         } else {
            arabicResult += arabicResultCurrent;
         }

         arabicResultPrevious = arabicResultCurrent;
      }

      return arabicResult;
   }

}
