package com.example.demo.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD , ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = passwordValidated.class)
public @interface Password {

    String message() default "Password must be contain atleast one upperCase , one lower case , one charcter and any integer number ";

    // represent group of constraints
    Class<?>[] groups() default {};

    //additional informmation about annoatation
    Class<? extends Payload>[] payload() default {};
}
