package com.adobe.aem.util;

import org.springframework.stereotype.Component;
import static com.adobe.aem.util.RomanNumeralConstants.INVALID_QUERY_ERROR_MESSAGE;

@Component
public class RomanNumeralValidations {

    public boolean validateQueryValue(int num) {
        if (num <= 0 || num > 255) {
            throw new IllegalArgumentException(INVALID_QUERY_ERROR_MESSAGE);
        }
        return true;
    }

}
