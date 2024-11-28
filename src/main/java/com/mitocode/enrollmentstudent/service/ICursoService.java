package com.mitocode.enrollmentstudent.service;

import com.mitocode.enrollmentstudent.model.Curso;

public interface ICursoService extends ICRUD<Curso,Integer> {
    boolean existsCursoByNombre(String nombre);
}
