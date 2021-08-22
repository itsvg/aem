package com.adobe.aem.service.Impl;

import com.adobe.aem.service.RomanNumeralService;
import org.springframework.stereotype.Component;

@Component
public class RomanNumeralServiceImpl implements RomanNumeralService {

    /**
     * Integer values list.
     */
    private static int[] INT_VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    /**
     * Roman numerals mapping list.
     */
    private static String[] ROMAN_NUMERALS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    /**
     * Get Roman Numeral equivalent to integer value in range {1-3999}.
     *
     * @param num
     * @return
     */
    public String getIntegerToRoman(int num) {

        StringBuilder result = new StringBuilder();
        while (num > 0) {
            for (int i = 0; i < INT_VALUES.length; i++) {
                if (num >= INT_VALUES[i]) {
                    result.append(ROMAN_NUMERALS[i]);
                    num -= INT_VALUES[i];
                    break;
                }
            }
        }
        return result.toString();
    }
}
