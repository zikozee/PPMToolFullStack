package com.zikozee.ppmtool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntityNotFoundException extends ProjectException{
    public EntityNotFoundException(String message) {
        super(message);
    }
}
