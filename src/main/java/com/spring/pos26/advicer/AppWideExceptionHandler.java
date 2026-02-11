package com.spring.pos26.advicer;

import com.spring.pos26.exception.NotFoundException;
import com.spring.pos26.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException e) {
        return  new ResponseEntity<StandardResponse>(
                new StandardResponse(404,"Error coming ",e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
}
