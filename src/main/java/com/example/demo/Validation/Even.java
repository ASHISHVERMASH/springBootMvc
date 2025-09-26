package com.example.demo.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD , ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EvenNumber.class)
@Documented

public @interface Even {

    String message() default "Number is odd ";

    // represent group of constraints
    Class<?>[] groups() default {};

    //additional informmation about annoatation
    Class<? extends Payload>[] payload() default {};
}
