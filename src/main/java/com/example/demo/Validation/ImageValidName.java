package com.example.demo.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class ImageValidName implements ConstraintValidator<ImageName , String> {

    private Logger logger = (Logger) LoggerFactory.getLogger(ImageValidName.class);

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {


        // logic
            if(value.isBlank()){
                return false;
            }else {
                return true;
            }

    }
}
