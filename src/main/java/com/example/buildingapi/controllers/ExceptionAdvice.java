package com.example.buildingapi.controllers;

import com.example.buildingapi.exceptions.NotFoundException;
import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> generateError(Exception exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatusCode.valueOf(HttpStatus.SC_NOT_FOUND));
    }
}
