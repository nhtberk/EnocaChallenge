package com.nhtberk.berkchallenge.exception;

public class UniversityNotFoundException extends RuntimeException{

    public UniversityNotFoundException(long id){
        super("Couldn't find university "+id);
    }
}
