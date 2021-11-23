package com.example.rez.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such feature")
public class FeatureNotFound extends RuntimeException {

    public FeatureNotFound() {
    }

    public FeatureNotFound(String message) {
        super(message);
    }

    public FeatureNotFound(String message, Throwable cause) {
        super(message, cause);

    }
}