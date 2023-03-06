package com.example.bookmymovie.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.AbstractMap;

@ControllerAdvice
@Slf4j
public class MovieExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<AbstractMap.SimpleEntry<String, String>> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity(getError("Unknown Error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({MovieException.class})
    public ResponseEntity<AbstractMap.SimpleEntry<String, String>> handleCommonException(MovieException e) {
        log.error(e.getMessage());
        return new ResponseEntity(getError(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    private AbstractMap.SimpleEntry<String, String> getError(String errorMsg) {
        return new AbstractMap.SimpleEntry<>("errorMessage", errorMsg);
    }
}
