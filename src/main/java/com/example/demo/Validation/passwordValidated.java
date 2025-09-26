package com.example.demo.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class passwordValidated implements ConstraintValidator< Password , String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if(s ==  null){
            return false;
        }

        if(!s.matches(".*[A-Z].*")){
            return false;
        }

        if(!s.matches(".*[a-z].*")){
            return false;
        }

        if(!s.matches(".*[0-9].*")){
            return false;
        }

        if(s.length()<10){
            return false;
        }

        if(!s.matches(".*[A-Za-z0-9]")){
            return false;
        }
        return true;
    }
}
