package com.music.music.exceptions;
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}