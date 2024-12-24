package com.example.cacSpringBoot.exceptions;

import com.example.cacSpringBoot.dto.response.ErrorDto;
import com.example.cacSpringBoot.dto.response.ValidationErrorDto;
import com.example.cacSpringBoot.enums.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.ArrayList;
import java.util.List;

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

    // Controlar argumenos ilegales en el body
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDto> ilegalArgumentInBody(HttpMessageNotReadableException e){
        return new ResponseEntity<>(
                new ErrorDto(
                        400,
                        e.getMessage()
                ),
                HttpStatus.BAD_REQUEST
        );
    }

    // Controlar argumentos ilegales en los params
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorDto> ilegalArgumentInBody(MethodArgumentTypeMismatchException e){
        return new ResponseEntity<>(
                new ErrorDto(
                        400,
                        e.getMessage()
                ),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorDto> handleValidationExceptions(MethodArgumentNotValidException ex){
        BindingResult result = ex.getBindingResult();
        List<String> errorsList = new ArrayList<>();

        for (FieldError error : result.getFieldErrors()) {
            if (error.getDefaultMessage() != null){
                errorsList.add(error.getField() + ": " + error.getDefaultMessage());
            }
        }

        return new ResponseEntity<>(
                new ValidationErrorDto(
                        false,
                        Status.ERROR,
                        "Validation Error",
                        errorsList
                ), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDto> nullResponse(NullPointerException e){
        return new ResponseEntity<>(new ErrorDto(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
