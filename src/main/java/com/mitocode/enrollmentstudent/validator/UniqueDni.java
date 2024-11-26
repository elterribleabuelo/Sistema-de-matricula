package com.mitocode.enrollmentstudent.validator;

import com.mitocode.enrollmentstudent.validator.impl.UniqueDniValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueDniValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)

public @interface UniqueDni {
    String message() default "El DNI ya está registrado";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
