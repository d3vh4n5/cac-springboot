package com.example.cacSpringBoot.exceptions;

import com.example.cacSpringBoot.dto.response.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> notFoundException(UserNotFoundException e){
        ErrorDto errorDto = new ErrorDto(404, e.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidJsonException.class)
    public ResponseEntity<ErrorDto> invalidJsonException(InvalidJsonException e){
        ErrorDto errorDto = new ErrorDto(400, e.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorDto> resourceNotFoundException(NoResourceFoundException e){
        // return new ResponseEntity<>(new ErrorDto(404, e.getMessage()), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(
                new ErrorDto(
                        404,
                        "Route: /" + e.getResourcePath() +" does not exist in application"
                ),
                HttpStatus.NOT_FOUND);
    }
}
