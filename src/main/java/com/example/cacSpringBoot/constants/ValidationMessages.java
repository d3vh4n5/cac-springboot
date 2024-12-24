package com.example.cacSpringBoot.constants;

public class ValidationMessages {
    public static  final String NOT_NULL = "can not be null";
    public static  final String NOT_BLANK = "can not be blank";
    public static final String REQUIRED = "is required";
    public static final String NAME_SIZE = "El nombre debe tener entre "+ ValidationConstraints.MIN_NAME_CHARS +" y "+ValidationConstraints.MAX_NAME_CHARS+" caracteres";
    public static final String AGE_POSITIVE = "La edad debe ser un número positivo";
    public static final String AGE_MAX = "La edad no puede ser mayor a "+ValidationConstraints.MAX_AGE+" años";
}
