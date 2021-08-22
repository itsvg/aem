package com.adobe.aem.controller;

import com.adobe.aem.service.RomanNumeralService;
import com.adobe.aem.util.RomanNumeralValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RomanNumeralController {

    /**
     * Constant for uri.
     */
    private static final String ROMAN_NUMERAL_URI = "/romannumeral";
    /**
     * Constant for input.
     */
    private static final String INPUT = "input";
    /**
     * Constant for output.
     */
    private static final String OUTPUT = "output";

    // private static final Logger LOGGER = LoggerFactory.getLogger(RomanNumeralController.class);

    @Autowired
    RomanNumeralService romanNumeralService;

    @Autowired
    RomanNumeralValidations romanNumeralValidations;

    /**
     * Get Roman Numeral from an integer value in range of 1 - 255.
     * If query value is
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
            error.put("message", ex.getMessage());
            error.put("status", HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
}
