package com.restapis.examples.springbootrestapisexamples.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse(String message, HttpStatus statusCode, Object object) {

        Map<String, Object> responseObj = new HashMap<>() {{
         put("message", message);
         put("statusCode", statusCode.value());
         put("data", object);
        }};
        return new ResponseEntity<>(responseObj,statusCode);
    }

}
