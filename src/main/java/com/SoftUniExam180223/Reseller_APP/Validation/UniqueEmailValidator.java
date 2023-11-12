package com.SoftUniExam180223.Reseller_APP.Validation;

import com.SoftUniExam180223.Reseller_APP.Repository.UserRepository;
import com.SoftUniExam180223.Reseller_APP.Service.Impl.UserServiceImpl;
import com.SoftUniExam180223.Reseller_APP.Validation.annotation.UniqueEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {


private final UserRepository userRepository;


    public UniqueEmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

    return userRepository.findByEmail(value).isEmpty();

    }
}