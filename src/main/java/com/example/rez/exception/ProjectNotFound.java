package com.example.rez.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such project")
public class ProjectNotFound extends RuntimeException {

    public ProjectNotFound() {
    }

    public ProjectNotFound(String message) {
        super(message);
    }

    public ProjectNotFound(String message, Throwable cause) {
        super(message, cause);

    }
}