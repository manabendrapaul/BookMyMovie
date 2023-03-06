package com.example.bookmymovie.exception;

import lombok.Getter;

import java.util.Map;

@Getter
public class MovieException extends RuntimeException {

    private Map<String, String> errorData;

    public MovieException(String msg) {
        super(msg);
    }

}
