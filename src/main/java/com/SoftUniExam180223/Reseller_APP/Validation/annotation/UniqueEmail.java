package com.SoftUniExam180223.Reseller_APP.Validation.annotation;

import com.SoftUniExam180223.Reseller_APP.Validation.UniqueEmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueEmailValidator.class)
public @interface UniqueEmail {
    String message() default "Email already exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}