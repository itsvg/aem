package com.adobe.aem;

import com.adobe.aem.controller.RomanNumeralController;
import com.adobe.aem.service.RomanNumeralService;
import com.adobe.aem.util.RomanNumeralValidations;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RomanNumeralControllerTest {

    private RomanNumeralController romanNumeralController;

    @Mock
    private RomanNumeralService romanNumeralService;

    @Mock
    private RomanNumeralValidations romanNumeralValidations;

    @Before
    public void setUp() {
        romanNumeralController = new RomanNumeralController();
        ReflectionTestUtils.setField(romanNumeralController, "romanNumeralService", romanNumeralService);
        ReflectionTestUtils.setField(romanNumeralController, "romanNumeralValidations", romanNumeralValidations);
    }

    @Test
    public void shouldReturnAValidRomanNumeralResponse() {

        Map<String, Object> expectedResponseMap = new HashMap<>();
        expectedResponseMap.put("input", "201");
        expectedResponseMap.put("output", "CCI");
        ResponseEntity<Map<String, Object>> expectedJson  = new ResponseEntity<>(expectedResponseMap, HttpStatus.OK);

        int num = 201;
        String romanNumeralStub = "CCI";

        when(romanNumeralValidations.validateQueryValue(num)).thenReturn(true);
        when(romanNumeralService.getIntegerToRoman(num)).thenReturn(romanNumeralStub);
        ResponseEntity<Map<String, Object>> res = romanNumeralController.getRomanNumeral(num);

        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertEquals(expectedJson, res);
    }
}
