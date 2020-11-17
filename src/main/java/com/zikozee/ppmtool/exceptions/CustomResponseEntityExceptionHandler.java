package com.zikozee.ppmtool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleProjectIdException(ProjectIdException ex, WebRequest request){
        ProjectExceptionResponse exceptionResponse = new ProjectExceptionResponse(ex.getMessage());
        return  new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handlePpmToolException(ProjectException ex, WebRequest request){
        ProjectExceptionResponse exceptionResponse = new ProjectExceptionResponse(ex.getMessage());
        return  new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
