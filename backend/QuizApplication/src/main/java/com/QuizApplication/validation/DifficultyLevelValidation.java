package com.QuizApplication.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DifficultyLevelValidator.class )
@Documented
public @interface DifficultyLevelValidation {
    String message() default "DifficultyLevel must be either easy or hard or medium";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
