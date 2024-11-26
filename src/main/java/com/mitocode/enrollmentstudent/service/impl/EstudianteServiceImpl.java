package com.mitocode.enrollmentstudent.service.impl;

import com.mitocode.enrollmentstudent.model.Estudiante;
import com.mitocode.enrollmentstudent.repo.IEstudianteRepo;
import com.mitocode.enrollmentstudent.repo.IGenericRepo;
import com.mitocode.enrollmentstudent.service.IEstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor

@Service
public class EstudianteServiceImpl extends CRUDImpl<Estudiante,Integer> implements IEstudianteService {

    private final IEstudianteRepo repo;

    @Override
    protected IGenericRepo getRepo() {

        return repo;
    }

    @Override
    public List<Estudiante> orderByAge() {
        List<Estudiante> list = repo.findAll();
        return  list
                .stream()
                .sorted(Comparator.comparing(Estudiante::getEdad).reversed())
                .toList();
    }
}
