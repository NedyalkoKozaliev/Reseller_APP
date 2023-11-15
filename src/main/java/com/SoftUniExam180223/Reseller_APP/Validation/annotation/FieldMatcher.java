package com.SoftUniExam180223.Reseller_APP.Validation.annotation;

import com.SoftUniExam180223.Reseller_APP.Validation.MatcherValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = MatcherValidator.class)
public @interface FieldMatcher {

    String first();
    String second();
    String message() default "Email already exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
