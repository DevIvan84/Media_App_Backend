package com.hospital.exception;


//s@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ModelNotFoundException extends RuntimeException{

    public ModelNotFoundException(String message) {
        super(message);
    }
}
