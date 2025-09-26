package com.example.demo.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD , ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PrimeNumber.class)

public @interface  Prime {

    String message() default "Invalid image name ";

    // represent group of constraints
    Class<?>[] groups() default {};

    //additional informmation about annoatation
    Class<? extends Payload>[] payload() default {};

}
