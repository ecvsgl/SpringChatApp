package com.devexperts.ria.internship.chatify.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class RestErrorHandler {

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<ChatifyExceptionTemplate> handleException(IllegalArgumentException e){
        return new ResponseEntity<>(getChatifyExceptionTemplate(HttpStatus.BAD_REQUEST, e.getMessage()),HttpStatus.BAD_REQUEST);
    }

    private ChatifyExceptionTemplate getChatifyExceptionTemplate(HttpStatus status, String msg){
        return new ChatifyExceptionTemplate(status.value(),msg,LocalDateTime.now());
    }
}
