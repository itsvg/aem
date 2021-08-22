package com.adobe.aem.controller;

import com.adobe.aem.service.RomanNumeralService;
import com.adobe.aem.util.RomanNumeralValidations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static com.adobe.aem.util.RomanNumeralConstants.INPUT;
import static com.adobe.aem.util.RomanNumeralConstants.MESSAGE;
import static com.adobe.aem.util.RomanNumeralConstants.OUTPUT;
import static com.adobe.aem.util.RomanNumeralConstants.ROMAN_NUMERAL_URI;
import static com.adobe.aem.util.RomanNumeralConstants.STATUS;

@RestController
public class RomanNumeralController {

    @Autowired
    RomanNumeralService romanNumeralService;

    @Autowired
    RomanNumeralValidations romanNumeralValidations;

    /**
     * Get Roman Numeral from an integer value in range of 1 - 255.
     * If query value is 0 or greater than 255, return Invalid query value message.
     *
     * @param num integer value
     * @return Json payload with input and output values
     */
    @GetMapping(path = ROMAN_NUMERAL_URI, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getRomanNumeral(@RequestParam("query") int num) {
        Map<String, Object> res = new HashMap<>();
        try {
            if (romanNumeralValidations.validateQueryValue(num)) {
                String out = romanNumeralService.getIntegerToRoman(num);
                res.put(INPUT, Integer.toString(num));
                res.put(OUTPUT, out);
            }
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception ex) {
            Map<String, Object> error = new HashMap<>();
            error.put(MESSAGE, ex.getMessage());
            error.put(STATUS, HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
}
