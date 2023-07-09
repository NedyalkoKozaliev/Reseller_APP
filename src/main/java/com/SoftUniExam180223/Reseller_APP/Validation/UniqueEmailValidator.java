package com.SoftUniExam180223.Reseller_APP.Validation;

import com.SoftUniExam180223.Reseller_APP.Service.Impl.UserServiceImpl;
import com.SoftUniExam180223.Reseller_APP.Validation.annotation.UniqueEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserServiceImpl userService;



    public UniqueEmailValidator(UserServiceImpl userService) {
        this.userService = userService;
    }



    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.userService.findUserByEmail(value) == null;
    }
}