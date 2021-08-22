package com.adobe.aem.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class RomanNumeralValidationsTest {

    public static final int VALID_QUERY_VAL = 200;
    public static final int INVALID_QUERY_VAL = 551;

    private RomanNumeralValidations romanNumeralValidations;

    @Before
    public void setup() {
        romanNumeralValidations = new RomanNumeralValidations();
    }

    @Test
    public void shouldReturnTrueWhenQueryIsWithValidValue() {
        assertTrue(romanNumeralValidations.validateQueryValue(VALID_QUERY_VAL));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenQueryIsWithInvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            romanNumeralValidations.validateQueryValue(INVALID_QUERY_VAL);
        });
    }
}
