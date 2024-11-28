package com.mitocode.enrollmentstudent.validator.impl;

import com.mitocode.enrollmentstudent.repo.IEstudianteRepo;
import com.mitocode.enrollmentstudent.validator.UniqueDni;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

@Component
public class UniqueDniValidator implements ConstraintValidator<UniqueDni, String> {

    private final IEstudianteRepo repo;

    @Override
    public boolean isValid(String dni, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("sss:" + repo.existsEstudianteByDni(dni));
        return !repo.existsEstudianteByDni(dni);
    }
}
