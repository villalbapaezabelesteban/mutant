package com.challenge.mutant.exception.entity;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class NotMutantException extends Exception {

    public NotMutantException() {
        super("Not a mutant");
    }
}