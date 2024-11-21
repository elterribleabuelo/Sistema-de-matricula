package com.mitocode.enrollmentstudent.service.impl;

import com.mitocode.enrollmentstudent.model.Matricula;
import com.mitocode.enrollmentstudent.repo.IGenericRepo;
import com.mitocode.enrollmentstudent.repo.IMatriculaRepo;
import com.mitocode.enrollmentstudent.service.IMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class MatriculaServiceImpl extends CRUDImpl<Matricula,Integer> implements IMatriculaService {

    private final IMatriculaRepo repo;

    @Override
    protected IGenericRepo getRepo() {
        return repo;
    }
}
