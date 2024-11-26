package com.mitocode.enrollmentstudent.service;

import com.mitocode.enrollmentstudent.model.Matricula;

import java.util.List;
import java.util.Map;

public interface IMatriculaService extends ICRUD<Matricula,Integer>{
    Map<String,  List<String>> getStudentsByCourse();
}
