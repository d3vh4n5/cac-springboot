package com.example.cacSpringBoot.dto.response;

import com.example.cacSpringBoot.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ValidationErrorDto {
    private boolean ok;
    private Status status;
    private String message;
    private List<String> errors;
}

