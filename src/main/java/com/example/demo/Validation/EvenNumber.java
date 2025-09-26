package com.example.demo.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EvenNumber  implements ConstraintValidator<Even , Integer> {
    @Override
    public boolean isValid(Integer s, ConstraintValidatorContext constraintValidatorContext) {
        if(s%2 != 0 ){
            return false;
        }
        return true;
    }
}
