package com.devsuperior.bds02.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public StandardError entityNotFound(ResourceNotFoundException exception, HttpServletRequest request) {
        return error(exception, request, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DatabaseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public StandardError databaseException(DatabaseException exception, HttpServletRequest request) {
        return error(exception, request, HttpStatus.BAD_REQUEST);
    }

    private StandardError error(Exception ex, HttpServletRequest request, HttpStatus status) {
        StandardError err = new StandardError();
        err.setStatus(status.value());
        err.setMessage(ex.getMessage());
        err.setPath(request.getRequestURI());
        return err;
    }
}
