package com.adobe.aem.util;

import org.springframework.stereotype.Component;

@Component
public class RomanNumeralValidations {

    public boolean validateQueryValue(int num) {
        if (num <= 0 || num > 255) {
            throw new IllegalArgumentException(RomanNumeralConstants.INVALID_QUERY_ERROR_MESSAGE);
        }
        return true;
    }

}
