package com.mitocode.enrollmentstudent.service;

import com.mitocode.enrollmentstudent.model.Estudiante;

import java.util.List;

public interface IEstudianteService extends ICRUD<Estudiante, Integer> {
    List<Estudiante> orderByAge();
    boolean existsEstudianteByDni(String dni);
}
