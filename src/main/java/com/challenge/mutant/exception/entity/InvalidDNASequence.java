package com.challenge.mutant.exception.entity;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidDNASequence extends Exception {
    public InvalidDNASequence() {
        super("Invalid DNA sequence. One or more characters in the sequence is not among the allowed [A,T,C,G].");
    }
}