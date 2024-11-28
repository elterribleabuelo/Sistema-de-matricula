package com.mitocode.enrollmentstudent.validator.impl;

import com.mitocode.enrollmentstudent.repo.ICursoRepo;
import com.mitocode.enrollmentstudent.validator.UniqueNameCourse;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

@Component
public class UniqueNameCourseValidator implements ConstraintValidator<UniqueNameCourse, String> {

    private final ICursoRepo repo;

    @Override
    public boolean isValid(String nombre, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("www:" + repo.existsCursoByNombre(nombre));
        return !repo.existsCursoByNombre(nombre);
    }
}
