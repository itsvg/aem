package com.adobe.aem.service.Impl;

import com.adobe.aem.service.RomanNumeralService;
import org.springframework.stereotype.Component;

@Component(value = "romanNumeralServiceImpl")
public class RomanNumeralServiceImpl implements RomanNumeralService {

    /**
     * Integer value.
     */
    private static int[] values = {100, 90, 50, 40, 10, 9, 5, 4, 1};

    /**
     * Roman numerals.
     */
    private static String[] roman = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    /**
     * Get Roman Numeral equivalent to integer value in range {1-255}.
     *
     * @param num
     * @return
     */
    public String getIntegerToRoman(int num) {

        StringBuilder result = new StringBuilder();
        while (num > 0) {
            for (int i = 0; i < values.length; i++) {
                if (num >= values[i]) {
                    result.append(roman[i]);
                    num -= values[i];
                    break;
                }
            }
        }
        return result.toString();
    }
}
