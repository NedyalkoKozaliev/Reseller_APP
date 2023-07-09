package com.SoftUniExam180223.Reseller_APP.Validation;

import com.SoftUniExam180223.Reseller_APP.Service.Impl.UserServiceImpl;
import com.SoftUniExam180223.Reseller_APP.Validation.annotation.UniqueEmail;
import com.SoftUniExam180223.Reseller_APP.Validation.annotation.UniqueUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserServiceImpl userService;

    public UniqueUsernameValidator(UserServiceImpl userService) {
        this.userService = userService;
    }




    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.userService.findUserByUsername(value) == null;
    }
}