package com.example.demo.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeNumber implements ConstraintValidator<Prime , Integer> {
    @Override
    public boolean isValid(Integer n, ConstraintValidatorContext constraintValidatorContext) {

        if(n == null || n <= 1){
            return false;
        }
        for (int i = 2; i < n; i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
