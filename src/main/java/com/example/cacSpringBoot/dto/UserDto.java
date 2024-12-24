package com.example.cacSpringBoot.dto;

import com.example.cacSpringBoot.constants.ValidationConstraints;
import com.example.cacSpringBoot.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

import jakarta.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    public static final String NOT_NULL = "cannot be null";

    @NotNull(message=ValidationMessages.REQUIRED)
    @NotBlank(message=ValidationMessages.NOT_BLANK)
    @Size(
            min= ValidationConstraints.MIN_NAME_CHARS,
            max=ValidationConstraints.MAX_NAME_CHARS,
            message = ValidationMessages.NAME_SIZE
    )
    private String name;

    @Positive(message=ValidationMessages.AGE_POSITIVE)
    @Max(value=ValidationConstraints.MAX_AGE, message=ValidationMessages.AGE_MAX)
    private Integer edad;

    /*S
    @Pattern ??
    * @NotNull
    * @AssertTrue
    * @Size
    * @Min
    * @Max
    * @Email
    * @NotEmpty
    * @NotBlank
    * @Positive
    * @Negative
    * @PositiveOrZero
    * @Past
    * @PastOrPresent
    * @Future @FutureOrPresent
    * */
}
