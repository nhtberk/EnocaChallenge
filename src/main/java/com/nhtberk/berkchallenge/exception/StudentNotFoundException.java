package com.nhtberk.berkchallenge.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(long id){
        super("Couldn't find student "+id);
    }
}
